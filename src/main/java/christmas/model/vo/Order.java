package christmas.model.vo;

import christmas.exception.OverMaxQuantityException;
import java.util.Map;

public class Order {

    private static final Integer MAX_QUANTITY = 20;

    private final Map<Food, Quantity> orderInfo;

    public Order(Map<Food, Quantity> orderInfo) {
        validate(orderInfo);
        this.orderInfo = orderInfo;
    }

    private void validate(Map<Food, Quantity> orderInfo) {
        if (!isLessThanMaxQuantity(orderInfo)) {
            throw new OverMaxQuantityException(MAX_QUANTITY);
        }
    }

    private boolean isLessThanMaxQuantity(Map<Food, Quantity> orderInfo) {
        Integer sumAmount = orderInfo.values().stream()
                .mapToInt(Quantity::getAmount)
                .sum();
        return sumAmount <= MAX_QUANTITY;
    }
}
