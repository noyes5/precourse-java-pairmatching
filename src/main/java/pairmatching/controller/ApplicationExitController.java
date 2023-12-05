package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ApplicationExitController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationExitController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {

    }
}
