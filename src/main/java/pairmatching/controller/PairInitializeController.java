package pairmatching.controller;

import pairmatching.domain.repository.PairResults;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairInitializeController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public PairInitializeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        PairResults.deleteAll();
        outputView.printCompleteResultsInitialized();
    }
}
