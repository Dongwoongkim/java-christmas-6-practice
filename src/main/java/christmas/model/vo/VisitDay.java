package christmas.model.vo;

import christmas.exception.InvalidDayException;
import java.util.List;

public class VisitDay {

    private static final List<Integer> WEEKEND = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private static final List<Integer> SPECIAL_DAY = List.of(3, 10, 17, 24, 25, 31);
    private static final Integer CHRISTMAS_DAY = 25;

    private static final Integer FIRST_DAY_OF_MONTH = 1;
    private static final Integer LAST_DAY_OF_MONTH = 31;
    private final Integer day;

    public VisitDay(Integer day) {
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) {
        if (!isInRangeDecember(day)) {
            throw new InvalidDayException();
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

    public boolean isWeekend() {
        if (WEEKEND.contains(day)) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        if (SPECIAL_DAY.contains(day)) {
            return true;
        }
        return false;
    }

    public boolean isBeforeChristmas() {
        if (day <= CHRISTMAS_DAY) {
            return true;
        }
        return false;
    }
}
