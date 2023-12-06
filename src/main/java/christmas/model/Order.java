package christmas.model;

import christmas.exception.OverMaxQuantityException;
import christmas.model.vo.Food;
import christmas.model.vo.Quantity;
import java.util.Map;

public class Order {

    private static final Integer MAX_QUANTITY = 20;

    private final Map<Food, Quantity> information;

    public Order(Map<Food, Quantity> information) {
        validate(information);
        this.information = information;
    }

    private void validate(Map<Food, Quantity> information) {
        if (!isLessThanMaxQuantity(information)) {
            throw new OverMaxQuantityException();
        }
    }

    private boolean isLessThanMaxQuantity(Map<Food, Quantity> information) {
        Integer sumAmount = information.values().stream()
                .mapToInt(Quantity::getAmount)
                .sum();
        return sumAmount <= MAX_QUANTITY;
    }

    public Integer getTotalOrderPrice() {
        return information.keySet().stream()
                .mapToInt(food -> Menu.getFoodPrice(food.name()) * information.get(food).getAmount())
                .sum();
    }

    public Map<Food, Quantity> getInformation() {
        return information;
    }

    public Integer getQuantity(Menu menu) {
        return information.entrySet()
                .stream()
                .filter(order -> menu.getFood().containsKey(order.getKey().name()))
                .mapToInt(order -> order.getValue().getAmount())
                .sum();
    }
}
