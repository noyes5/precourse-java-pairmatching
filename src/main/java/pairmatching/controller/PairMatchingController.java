package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairResult;
import pairmatching.domain.ParingInfo;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements ControllerHandler {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final InputView inputView;
    private final OutputView outputView;
    private PairResult result;

    private int attempts = 1;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        ParingInfo paringInfo = readParingInfo();
        result = new PairResult(paringInfo);
        outputView.printPairResult(result);
    }

    private ParingInfo readParingInfo() {
        while (true) {
            try {
                List<String> paringInfo = inputView.readParingInfo();
                Course course = Course.from(paringInfo.get(COURSE_INDEX));
                Level level = Level.from(paringInfo.get(LEVEL_INDEX));
                Mission mission = new Mission(paringInfo.get(MISSION_INDEX));
                return new ParingInfo(course, level, mission);
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    public void selectPairingOption() {

    }
}
