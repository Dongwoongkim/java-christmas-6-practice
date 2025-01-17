package christmas.exception;

import christmas.exception.message.ErrorMessage;

public class OverMaxQuantityException extends IllegalArgumentException {

    public OverMaxQuantityException() {
        super(ErrorMessage.INVALID_ORDER_EXCEPTION.getMessage());
    }
}
