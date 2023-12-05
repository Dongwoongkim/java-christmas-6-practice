package christmas.model.vo;

public class Food {

    private final String name;

    public Food(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        // TODO : 메뉴에 있는 주문인지 검사
    }
}
