package christmas.model.vo;

import christmas.exception.InvalidDayException;

public class VisitDay {

    private static final Integer FIRST_DAY_OF_MONTH = 1;
    private static final Integer LAST_DAY_OF_MONTH = 31;
    private final Integer day;

    public VisitDay(Integer day) {
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) {
        if (!isInRangeDecember(day)) {
            throw new InvalidDayException(FIRST_DAY_OF_MONTH, LAST_DAY_OF_MONTH);
        }
    }

    private boolean isInRangeDecember(Integer day) {
        if (day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_MONTH) {
            return true;
        }
        return false;
    }

    public Integer getDay() {
        return day;
    }
}
