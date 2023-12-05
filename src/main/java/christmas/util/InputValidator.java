package christmas.util;

public class InputValidator {

    private InputValidator() {
    }

    public void validateDate(String date) {
        if (date.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(date)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateOrder(String order) {
        if (order.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String date) {
        try {
            Integer.valueOf(date);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
