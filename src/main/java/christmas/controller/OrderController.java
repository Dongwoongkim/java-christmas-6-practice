package christmas.controller;

import static christmas.model.Menu.DESSERT;
import static christmas.model.Menu.MAIN;

import christmas.model.Badge;
import christmas.model.Benefit;
import christmas.model.Order;
import christmas.model.vo.Food;
import christmas.model.vo.Quantity;
import christmas.model.vo.VisitDay;
import christmas.util.InputConverter;
import christmas.util.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;


public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;

    public OrderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        showWelcomeMessage();

        VisitDay visitDay = initVisitDay();
        Order order = initOrder();
        Benefit benefit = initBenefit(order, visitDay);
        Badge badge = initBadge(benefit);

        showResult(visitDay, order, benefit, badge);
    }

    private void showWelcomeMessage() {
        outputView.printStartMessage();
    }

    private VisitDay initVisitDay() {
        while (true) {
            try {
                String day = inputView.readDay();
                InputValidator.validateDay(day);
                return new VisitDay(InputConverter.convertStringToInteger(day));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Order initOrder() {
        while (true) {
            try {
                String order = inputView.readOrderMenu();
                InputValidator.validateOrder(order);
                return new Order(InputConverter.convertStringToOrderMap(order));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Benefit initBenefit(Order order, VisitDay visitDay) {
        return Benefit.create(order.getTotalOrderPrice(), order.getQuantity(DESSERT), order.getQuantity(MAIN),
                visitDay);
    }

    private Badge initBadge(Benefit benefit) {
        return Badge.create(benefit.getTotalBenefitPrice());
    }

    private void showResult(VisitDay visitDay, Order order, Benefit benefit, Badge badge) {
        showPreviewMessage(visitDay.getDay());
        showOrderInfo(order.getInformation(), order.getTotalOrderPrice());
        showBenefitInfo(order, benefit, badge);
    }

    private void showPreviewMessage(Integer day) {
        outputView.printPreviewMessage(day);
    }

    private void showBenefitInfo(Order order, Benefit benefit, Badge badge) {
        outputView.printGift(benefit.isExistGift());
        outputView.printBenefitDetails(benefit.getDetails());
        outputView.printBenefitPrice(benefit.getTotalBenefitPrice());
        outputView.printOrderPriceAfterDiscount(order.getTotalOrderPrice() - benefit.getDiscountPrice());
        outputView.printBadge(badge.getName());
    }

    private void showOrderInfo(Map<Food, Quantity> information, Integer totalOrderPrice) {
        outputView.printOrderMenuHeader();
        information.forEach((food, quantity) -> outputView.printOrderMenu(food.name(), quantity.getAmount()));
        outputView.printOrderPriceBeforeDiscount(totalOrderPrice);
    }
}
