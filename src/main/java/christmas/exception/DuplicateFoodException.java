package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_ORDER_EXCEPTION;

public class DuplicateFoodException extends IllegalArgumentException {

    public DuplicateFoodException() {
        super(INVALID_ORDER_EXCEPTION.getMessage());
    }
}
