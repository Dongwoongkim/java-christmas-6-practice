package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_ORDER_EXCEPTION;

public class NonExistInMenuException extends IllegalArgumentException {

    public NonExistInMenuException() {
        super(INVALID_ORDER_EXCEPTION.getMessage());
    }
}
