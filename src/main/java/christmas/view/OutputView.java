package christmas.view;

import christmas.model.BenefitInfo;
import java.util.Map;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printPreviewMessage(Integer day) {
        System.out.println(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", day));
    }

    public void printOrderMenuHeader() {
        System.out.println("\n<주문 메뉴>");
    }

    public void printOrderMenu(String food, Integer quantity) {
        System.out.println(food + " " + quantity + "개");
    }

    public void printOrderPriceBeforeDiscount(Integer amount) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", amount));
    }

    public void printGift(boolean isExistGift) {
        System.out.println("\n<증정 메뉴>");
        if (isExistGift) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void printBenefitDetails(Map<BenefitInfo, Integer> benefitInfo) {
        System.out.println("\n<혜택 내역>");

        if (benefitInfo.isEmpty()) {
            System.out.println("없음");
            return;
        }

        for (BenefitInfo info : benefitInfo.keySet()) {
            System.out.println(String.format("%s : -%,d원", info.getBenefitName(), benefitInfo.get(info)));
        }
    }


    public void printBenefitPrice(Integer benefitPrice) {
        System.out.println("\n<총혜택 금액>");
        if (benefitPrice.equals(0)) {
            System.out.println("0원");
            return;
        }
        System.out.println(String.format("-%,d원", benefitPrice));
    }

    public void printOrderPriceAfterDiscount(Integer paymentAmount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", paymentAmount));
    }

    public void printBadge(String badgeName) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badgeName);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

