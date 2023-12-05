package christmas.exception;

public class NonNumericException extends IllegalArgumentException {

    public NonNumericException() {
        super("[ERROR] 입력하신 값에 문자가 포함되어 있습니다.");
    }
}
