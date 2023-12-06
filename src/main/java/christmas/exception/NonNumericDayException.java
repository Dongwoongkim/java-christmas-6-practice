package christmas.exception;

import static christmas.exception.message.ErrorMessage.INVALID_DAY_EXCEPTION;

public class NonNumericDayException extends IllegalArgumentException {

    public NonNumericDayException() {
        super(INVALID_DAY_EXCEPTION.getMessage());
    }
}
