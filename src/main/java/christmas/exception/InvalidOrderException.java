package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_ORDER_EXCEPTION;

public class InvalidOrderException extends IllegalArgumentException {

    public InvalidOrderException() {
        super(INVALID_ORDER_EXCEPTION.getMessage());
    }
}
