package christmas.exception;

public class ZeroQuantityException extends IllegalArgumentException {

    public ZeroQuantityException() {
        super("[ERROR] 주문 수량에 0이 포함되어 있습니다.");
    }
}
