package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PairResults {
    private static final Map<ParingInfo, PairResult> pairResults = new HashMap<>();

    private PairResults() {
    }

    public static void addPairResult(ParingInfo paringInfo, PairResult pairResult) {
        pairResults.put(paringInfo, pairResult);
    }

}
