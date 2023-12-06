package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_DAY_EXCEPTION;

public class EmptyDayException extends IllegalArgumentException {

    public EmptyDayException() {
        super(INVALID_DAY_EXCEPTION.getMessage());
    }
}
