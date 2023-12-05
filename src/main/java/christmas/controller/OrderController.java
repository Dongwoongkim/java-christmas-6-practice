package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;

    public OrderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
    }
}