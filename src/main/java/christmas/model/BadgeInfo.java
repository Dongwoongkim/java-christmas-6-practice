package christmas.model;

public enum BadgeInfo {

    SANTA_BADGE("산타", 20000),
    TREE_BADGE("트리", 10000),
    STAR_BADGE("별", 5000),
    NON_BADGE("없음", 0);

    private final String name;
    private final Integer requiredAmount;

    BadgeInfo(String name, Integer requiredAmount) {
        this.name = name;
        this.requiredAmount = requiredAmount;
    }

    public String getName() {
        return name;
    }

    public Integer getRequiredAmount() {
        return requiredAmount;
    }
}
