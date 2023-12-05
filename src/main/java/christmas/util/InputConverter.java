package christmas.util;

import christmas.exception.DuplicateFoodException;
import christmas.exception.QuantityNonNumericException;
import christmas.model.vo.Food;
import christmas.model.vo.Quantity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputConverter {

    private static final String ORDERS_DELIMITER = ",";
    private static final String ORDER_DELIMITER = "-";
    private static final Integer FOOD_INDEX = 0;
    private static final Integer QUANTITY_INDEX = 1;


    private InputConverter() {
    }

    public static Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }

    public static Map<Food, Quantity> convertStringToOrderMap(String input) {
        List<String> ordersInfo = convertStringToListByDelimiter(input);

        return ordersInfo.stream()
                .map(orderInfo -> orderInfo.split(ORDER_DELIMITER))
                .collect(Collectors.toMap(
                        orderInfo -> getFood(List.of(orderInfo)),
                        orderInfo -> getQuantity(List.of(orderInfo)),
                        (existing, replacement) -> {
                            throw new DuplicateFoodException();
                        }
                ));
    }

    private static List<String> convertStringToListByDelimiter(String input) {
        return Arrays.stream(input.split(ORDERS_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private static Food getFood(List<String> order) {
        return new Food(order.get(FOOD_INDEX).trim());
    }

    private static Quantity getQuantity(List<String> order) {
        try {
            return new Quantity(Integer.valueOf(order.get(QUANTITY_INDEX).trim()));
        } catch (NumberFormatException e) {
            throw new QuantityNonNumericException();
        }
    }
}
