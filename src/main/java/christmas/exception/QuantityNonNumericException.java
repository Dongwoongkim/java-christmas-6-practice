package christmas.exception;

public class QuantityNonNumericException extends IllegalArgumentException {

    public QuantityNonNumericException() {
        super("[ERROR] 입력하신 주문의 수량에 문자가 포함되어 있습니다");
    }
}
