package christmas.model.vo;

public class Quantity {

    private final Integer amount;

    public Quantity(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (!isOverZero(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOverZero(Integer amount) {
        if (amount > 0) {
            return true;
        }
        return false;
    }

    public Integer getAmount() {
        return amount;
    }
}
