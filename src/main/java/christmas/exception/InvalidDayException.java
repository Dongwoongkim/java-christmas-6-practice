package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_DAY_EXCEPTION;

public class InvalidDayException extends IllegalArgumentException {

    public InvalidDayException() {
        super(INVALID_DAY_EXCEPTION.getMessage());
    }
}
