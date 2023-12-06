package christmas.model;

public enum BenefitInfo {
    
    D_DAY_DISCOUNT("크리스마스 디데이 할인", 100),
    WEEKDAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DISCOUNT("주말 할인", 2023),
    SPECIAL_DISCOUNT("특별 할인", 1000),
    GIFT("증정 이벤트", Menu.getFoodPrice("샴페인"));

    private final String benefitName;
    private final Integer price;

    BenefitInfo(String benefitName, Integer price) {
        this.benefitName = benefitName;
        this.price = price;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public Integer getPrice() {
        return price;
    }
}
