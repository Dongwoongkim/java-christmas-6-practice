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

    private final Map<BenefitInfo, Integer> info;

    private Benefit(Map<BenefitInfo, Integer> info) {
        this.info = info;
    }

    public static Benefit create(Integer totalOrderAmount,
                                 Integer dessertQuantity, Integer mainQuantity,
                                 VisitDay visitDay) {
        Map<BenefitInfo, Integer> info = new HashMap<>();

        if (visitDay.isBeforeChristmas()) {
            info.put(D_DAY_DISCOUNT, 900 + D_DAY_DISCOUNT.getPrice() * visitDay.getDay());
        }
        if (visitDay.isWeekend() && !dessertQuantity.equals(0)) {
            info.put(WEEKEND_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * dessertQuantity);
        }
        if (!visitDay.isWeekend() && !mainQuantity.equals(0)) {
            info.put(WEEKDAY_DISCOUNT, WEEKDAY_DISCOUNT.getPrice() * mainQuantity);
        }
        if (visitDay.isSpecialDay()) {
            info.put(SPECIAL_DISCOUNT, SPECIAL_DISCOUNT.getPrice());
        }
        if (totalOrderAmount >= 120000) {
            info.put(GIFT, GIFT.getPrice());
        }

        return new Benefit(info);
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
        return 0;
    }

    public boolean isExistGift() {
        return info.containsKey(BenefitInfo.GIFT);
    }

    public Map<BenefitInfo, Integer> getInfo() {
        return info;
    }
}
