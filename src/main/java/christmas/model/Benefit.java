package christmas.model;

import static christmas.model.BenefitInfo.D_DAY_DISCOUNT;
import static christmas.model.BenefitInfo.GIFT;
import static christmas.model.BenefitInfo.SPECIAL_DISCOUNT;
import static christmas.model.BenefitInfo.WEEKDAY_DISCOUNT;
import static christmas.model.BenefitInfo.WEEKEND_DISCOUNT;

import christmas.model.vo.VisitDay;
import java.util.HashMap;
import java.util.Map;

public class Benefit {

    private static final Integer REQUIRED_AMOUNT_FOR_GIFT = 120000;
    private static final Integer DEFAULT_D_DAY_AMOUNT = 900;
    private static final Integer ZERO_AMOUNT = 0;
    private static final Integer ZERO_PRICE = 0;

    private final Map<BenefitInfo, Integer> info;

    private Benefit(Map<BenefitInfo, Integer> info) {
        this.info = info;
    }

    public static Benefit create(Integer totalOrderAmount,
                                 Integer dessertQuantity, Integer mainQuantity,
                                 VisitDay visitDay) {
        Map<BenefitInfo, Integer> info = new HashMap<>();

        putDDayDiscount(visitDay, info);
        putWeekendDiscount(dessertQuantity, visitDay, info);
        putWeekDayDiscount(mainQuantity, visitDay, info);
        putSpecialDayDiscount(visitDay, info);
        putGift(totalOrderAmount, info);

        return new Benefit(info);
    }

    private static void putGift(Integer totalOrderAmount, Map<BenefitInfo, Integer> info) {
        if (totalOrderAmount >= REQUIRED_AMOUNT_FOR_GIFT) {
            info.put(GIFT, GIFT.getPrice());
        }
    }

    private static void putSpecialDayDiscount(VisitDay visitDay, Map<BenefitInfo, Integer> info) {
        if (visitDay.isSpecialDay()) {
            info.put(SPECIAL_DISCOUNT, SPECIAL_DISCOUNT.getPrice());
        }
    }

    private static void putWeekDayDiscount(Integer mainQuantity, VisitDay visitDay, Map<BenefitInfo, Integer> info) {
        if (!visitDay.isWeekend() && !mainQuantity.equals(ZERO_AMOUNT)) {
            info.put(WEEKDAY_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * mainQuantity);
        }
    }

    private static void putWeekendDiscount(Integer dessertQuantity, VisitDay visitDay, Map<BenefitInfo, Integer> info) {
        if (visitDay.isWeekend() && !dessertQuantity.equals(ZERO_AMOUNT)) {
            info.put(WEEKEND_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * dessertQuantity);
        }
    }

    private static void putDDayDiscount(VisitDay visitDay, Map<BenefitInfo, Integer> info) {
        if (visitDay.isBeforeChristmas()) {
            info.put(D_DAY_DISCOUNT, DEFAULT_D_DAY_AMOUNT + D_DAY_DISCOUNT.getPrice() * visitDay.getDay());
        }
    }

    public Integer getTotalBenefitPrice() {
        return info.values()
                .stream()
                .mapToInt(Integer::intValue).sum();
    }

    public Integer getDiscountPrice() {
        return getTotalBenefitPrice() - getGiftPrice();
    }

    private Integer getGiftPrice() {
        if (info.containsKey(GIFT)) {
            return info.get(GIFT);
        }
        return ZERO_PRICE;
    }

    public boolean isExistGift() {
        return info.containsKey(BenefitInfo.GIFT);
    }

    public Map<BenefitInfo, Integer> getInfo() {
        return info;
    }
}
