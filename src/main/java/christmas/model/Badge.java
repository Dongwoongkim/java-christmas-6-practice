package christmas.model;

public class Badge {

    private final String name;

    private Badge(String name) {
        this.name = name;
    }

    public static Badge create(Integer totalBenefitPrice) {
        if (totalBenefitPrice >= 20000) {
            return new Badge("산타");
        }
        if (totalBenefitPrice >= 10000) {
            return new Badge("트리");
        }
        if (totalBenefitPrice >= 5000) {
            return new Badge("별");
        }
        return new Badge("없음");
    }

    public String getName() {
        return name;
    }
}
