package christmas.controller;

import christmas.model.vo.Order;
import christmas.model.vo.VisitDay;
import christmas.util.InputConverter;
import christmas.util.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;


public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;

    public OrderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDay visitDay = initVisitDay();
        Order order = initOrder();
    }

    private VisitDay initVisitDay() {
        while (true) {
            try {
                String date = inputView.readDate();
                InputValidator.validateDate(date);
                return new VisitDay(InputConverter.convertStringToInteger(date));
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
}
