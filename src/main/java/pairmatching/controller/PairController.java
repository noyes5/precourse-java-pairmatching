package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        inputView.readMainOption();
    }
}
