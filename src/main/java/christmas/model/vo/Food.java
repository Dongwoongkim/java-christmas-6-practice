package christmas.model.vo;

import christmas.model.Menu;

public record Food(String name) {

    public Food {
        validate(name);
    }

    private void validate(String name) {
        if (!Menu.isFoodContain(name)) {
            throw new IllegalArgumentException();
        }
    }
}
