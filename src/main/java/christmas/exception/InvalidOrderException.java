package christmas.exception;

public class InvalidOrderException extends IllegalArgumentException {

    public InvalidOrderException() {
        super("[ERROR] 유효하지 않은 주문 형식입니다.");
    }
}
