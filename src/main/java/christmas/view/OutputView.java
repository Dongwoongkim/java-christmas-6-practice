package christmas.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrderMenu() {
        System.out.println("<주문 메뉴>");
    }

    public void printOrderPriceBeforeDiscount() {
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printGift() {
        System.out.println("<증정 메뉴>");
    }

    public void printBenefitInfo() {
        System.out.println("<혜택 내역>");
    }

    public void printBenefitPrice() {
        System.out.println("<총혜택 금액>");
    }

    public void printOrderPriceAfterDiscount() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public void printBadge() {
        System.out.println("<12월 이벤트 배지>");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

