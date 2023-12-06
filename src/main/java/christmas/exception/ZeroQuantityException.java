package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_ORDER_EXCEPTION;

public class ZeroQuantityException extends IllegalArgumentException {

    public ZeroQuantityException() {
        super(INVALID_ORDER_EXCEPTION.getMessage());
    }
}
