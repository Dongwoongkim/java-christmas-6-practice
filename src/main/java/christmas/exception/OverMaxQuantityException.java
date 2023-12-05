package christmas.exception;

public class OverMaxQuantityException extends IllegalArgumentException {

    public OverMaxQuantityException(Integer maxQuantity) {
        super(String.format("[ERROR] 최대 주문 가능 수량은 %d입니다.", maxQuantity));
    }
}
