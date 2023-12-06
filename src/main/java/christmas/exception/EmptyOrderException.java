package christmas.exception;

import christmas.exception.message.ErrorMessage;

public class EmptyOrderException extends IllegalArgumentException {

    public EmptyOrderException() {
        super(ErrorMessage.INVALID_ORDER_EXCEPTION.getMessage());
    }
}
