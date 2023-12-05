package christmas.model.vo;

import christmas.exception.OverMaxQuantityException;
import christmas.model.Menu;
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
            throw new OverMaxQuantityException(MAX_QUANTITY);
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
}
