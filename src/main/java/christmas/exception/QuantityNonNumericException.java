package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_ORDER_EXCEPTION;

public class QuantityNonNumericException extends IllegalArgumentException {

    public QuantityNonNumericException() {
        super(INVALID_ORDER_EXCEPTION.getMessage());
    }
}
