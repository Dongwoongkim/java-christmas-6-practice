package christmas.exception;

public class InvalidDayException extends IllegalArgumentException {

    public InvalidDayException(Integer firstDay, Integer lastDay) {
        super(String.format("[ERROR] %d ~ %d 사이의 값을 입력해 주세요.", firstDay, lastDay));
    }
}
