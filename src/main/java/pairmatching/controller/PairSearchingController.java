package pairmatching.controller;

import static pairmatching.util.Constants.COURSE_INDEX;
import static pairmatching.util.Constants.LEVEL_INDEX;
import static pairmatching.util.Constants.MISSION_INDEX;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairResult;
import pairmatching.domain.PairResults;
import pairmatching.domain.ParingInfo;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairSearchingController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public PairSearchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        ParingInfo paringInfo = readParingInfo();

        if (PairResults.containsMatch(paringInfo)) {
            PairResult result = new PairResult(paringInfo);
            outputView.printPairResult(result);
        }
        if (!PairResults.containsMatch(paringInfo)) {
            outputView.printNoPairResult();
        }
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
}
