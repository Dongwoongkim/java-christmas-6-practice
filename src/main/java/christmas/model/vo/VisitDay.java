package christmas.model.vo;

public class VisitDay {

    private final Integer day;

    public VisitDay(Integer day) {
        validate(day);
        this.day = day;
    }

    private void validate(Integer day) {
        if (!isInRangeDecember(day)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInRangeDecember(Integer day) {
        if (day >= 1 && day <= 31) {
            return true;
        }
        return false;
    }
}
