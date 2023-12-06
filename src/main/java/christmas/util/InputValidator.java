package christmas.util;

import christmas.exception.EmptyDayException;
import christmas.exception.EmptyOrderException;
import christmas.exception.NonNumericDayException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDay(String day) {
        if (day.isEmpty()) {
            throw new EmptyDayException();
        }

        if (!isNumeric(day)) {
            throw new NonNumericDayException();
        }
    }

    public static void validateOrder(String order) {
        if (order.isEmpty()) {
            throw new EmptyOrderException();
        }
    }

    private static boolean isNumeric(String day) {
        try {
            Integer.valueOf(day);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
