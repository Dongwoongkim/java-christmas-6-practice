package christmas.model;

import static christmas.model.BadgeInfo.NON_BADGE;
import static christmas.model.BadgeInfo.SANTA_BADGE;
import static christmas.model.BadgeInfo.STAR_BADGE;
import static christmas.model.BadgeInfo.TREE_BADGE;

public class Badge {

    private final String name;

    private Badge(String name) {
        this.name = name;
    }

    public static Badge create(Integer totalBenefitPrice) {
        if (totalBenefitPrice >= SANTA_BADGE.getRequiredAmount()) {
            return new Badge(SANTA_BADGE.getName());
        }
        if (totalBenefitPrice >= TREE_BADGE.getRequiredAmount()) {
            return new Badge(TREE_BADGE.getName());
        }
        if (totalBenefitPrice >= STAR_BADGE.getRequiredAmount()) {
            return new Badge(STAR_BADGE.getName());
        }
        return new Badge(NON_BADGE.getName());
    }

    public String getName() {
        return name;
    }
}
