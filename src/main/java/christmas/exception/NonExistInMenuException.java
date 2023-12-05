package christmas.exception;

public class NonExistInMenuException extends IllegalArgumentException {

    public NonExistInMenuException() {
        super("[ERROR] 메뉴에 존재하지 않는 음식이 포함되어 있습니다.");
    }
}
