package christmas.model;

import static christmas.model.BenefitInfo.D_DAY_DISCOUNT;
import static christmas.model.BenefitInfo.GIFT;
import static christmas.model.BenefitInfo.SPECIAL_DISCOUNT;
import static christmas.model.BenefitInfo.WEEKDAY_DISCOUNT;
import static christmas.model.BenefitInfo.WEEKEND_DISCOUNT;

import christmas.model.vo.VisitDay;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Benefit {

    private static final Integer REQUIRED_AMOUNT_FOR_GIFT = 120000;
    private static final Integer DEFAULT_D_DAY_AMOUNT = 900;
    private static final Integer REQUIRED_AMOUNT_FOR_EVENT = 10000;
    private static final Integer ZERO_PRICE = 0;
    private static final Integer ZERO_QUANTITY = 0;

    private final Map<BenefitInfo, Integer> details;

    private Benefit(Map<BenefitInfo, Integer> details) {
        this.details = details;
    }

    public static Benefit create(Integer totalPrice, Integer dessertQuantity, Integer mainQuantity, VisitDay visitDay) {
        Map<BenefitInfo, Integer> details = new HashMap<>();

        if (totalPrice < REQUIRED_AMOUNT_FOR_EVENT) {
            return new Benefit(details);
        }

        putDDayDiscount(visitDay, details);
        putWeekendDiscount(dessertQuantity, visitDay, details);
        putWeekDayDiscount(mainQuantity, visitDay, details);
        putSpecialDayDiscount(visitDay, details);
        putGift(totalPrice, details);

        return new Benefit(details);
    }

    private static void putGift(Integer totalOrderAmount, Map<BenefitInfo, Integer> details) {
        if (totalOrderAmount >= REQUIRED_AMOUNT_FOR_GIFT) {
            details.put(GIFT, GIFT.getPrice());
        }
    }

    private static void putSpecialDayDiscount(VisitDay visitDay, Map<BenefitInfo, Integer> details) {
        if (visitDay.isSpecialDay()) {
            details.put(SPECIAL_DISCOUNT, SPECIAL_DISCOUNT.getPrice());
        }
    }

    private static void putWeekDayDiscount(Integer mainQuantity, VisitDay visitDay, Map<BenefitInfo, Integer> details) {
        if (!visitDay.isWeekend() && !mainQuantity.equals(ZERO_QUANTITY)) {
            details.put(WEEKDAY_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * mainQuantity);
        }
    }

    private static void putWeekendDiscount(Integer dessertQuantity, VisitDay visitDay,
                                           Map<BenefitInfo, Integer> details) {
        if (visitDay.isWeekend() && !dessertQuantity.equals(ZERO_QUANTITY)) {
            details.put(WEEKEND_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * dessertQuantity);
        }
    }

    private static void putDDayDiscount(VisitDay visitDay, Map<BenefitInfo, Integer> details) {
        if (visitDay.isBeforeChristmas()) {
            details.put(D_DAY_DISCOUNT, DEFAULT_D_DAY_AMOUNT + D_DAY_DISCOUNT.getPrice() * visitDay.getDay());
        }
    }

    public Integer getTotalBenefitPrice() {
        return details.values()
                .stream()
                .mapToInt(Integer::intValue).sum();
    }

    public Integer getDiscountPrice() {
        return getTotalBenefitPrice() - getGiftPrice();
    }

    private Integer getGiftPrice() {
        if (details.containsKey(GIFT)) {
            return details.get(GIFT);
        }
        return ZERO_PRICE;
    }

    public boolean isExistGift() {
        return details.containsKey(BenefitInfo.GIFT);
    }

    public Map<BenefitInfo, Integer> getDetails() {
        return Collections.unmodifiableMap(details);
    }
}
