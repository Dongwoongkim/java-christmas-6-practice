package christmas.util;

import christmas.exception.EmptyInputException;
import christmas.exception.NonNumericException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDate(String date) {
        if (date.isEmpty()) {
            throw new EmptyInputException();
        }

        if (!isNumeric(date)) {
            throw new NonNumericException();
        }
    }

    public static void validateOrder(String order) {
        if (order.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    private static boolean isNumeric(String date) {
        try {
            Integer.valueOf(date);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
