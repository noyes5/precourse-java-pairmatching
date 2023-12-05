package pairmatching.view;

import static pairmatching.util.Constants.PAIR_DELIMITER;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.PairResult;

public class OutputView {


    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printPairResult(PairResult pairResult) {
        List<Set<Crew>> pairMatchingResult = pairResult.getPairResult();
        System.out.println(Message.PAIR_MATCHING_RESULT.message);
        pairMatchingResult.stream()
                .forEach(pair -> System.out.println(formatEachPair(pair)));
    }

    private String formatEachPair(Set<Crew> pair) {
        return pair.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(PAIR_DELIMITER));
    }


    private enum Message {
        PAIR_MATCHING_RESULT("페어 매칭 결과입니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
