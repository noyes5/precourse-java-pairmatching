package pairmatching.controller;

import static pairmatching.util.Constants.COURSE_INDEX;
import static pairmatching.util.Constants.LEVEL_INDEX;
import static pairmatching.util.Constants.MISSION_INDEX;
import static pairmatching.util.ExceptionMessage.INVALID_REMATCH_ATTEMPTS;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairResult;
import pairmatching.domain.repository.PairResults;
import pairmatching.domain.ParingInfo;
import pairmatching.domain.Mission;
import pairmatching.domain.command.RematchCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements ControllerHandler {
    private final static int MAX_ATTEMPTS = 3;
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
        if (PairResults.containsMatch(paringInfo)) {
            RematchCommand rematchCommand = getRematchCommand();
            if (rematchCommand.isNo()) {
                process();
            }
            attempts++;
            if (attempts > MAX_ATTEMPTS) {
                throw new IllegalArgumentException(INVALID_REMATCH_ATTEMPTS.getMessage());
            }
        }
        if (PairResults.hasSamePairInSameLevel(result)) {
        }
        PairResults.addPairResult(paringInfo, result);
        outputView.printPairResult(result);
    }

    private RematchCommand getRematchCommand() {
        while (true) {
            try {
                return inputView.readRematchCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
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
