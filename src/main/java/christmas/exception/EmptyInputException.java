package christmas.exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super("[ERROR] 입력에 빈 값은 허용되지 않습니다.");
    }
}
