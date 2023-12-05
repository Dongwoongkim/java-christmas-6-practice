package christmas.view;

public class OutputView {

    public void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printPreviewMessage(Integer day) {
        System.out.println(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", day));
    }

    public void printOrderMenuHeader() {
        System.out.println("\n<주문 내역>");
    }

    public void printOrderMenu(String food, Integer quantity) {
        System.out.println(food + " " + quantity + "개");
    }

    public void printOrderPriceBeforeDiscount(Integer amount) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", amount));
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

