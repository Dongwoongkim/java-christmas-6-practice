package christmas.util;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDate(String date) {
        if (date.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(date)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateOrder(String order) {
        if (order.isEmpty()) {
            throw new IllegalArgumentException();
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
