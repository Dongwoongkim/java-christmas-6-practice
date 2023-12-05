package christmas.exception;

public class DuplicateFoodException extends IllegalArgumentException {

    public DuplicateFoodException() {
        super("[ERROR] 입력하신 주문에 중복된 메뉴가 존재합니다.");
    }
}
