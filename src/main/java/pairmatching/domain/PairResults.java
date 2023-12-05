package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PairResults {
    private static final Map<ParingInfo, PairResult> pairResults = new HashMap<>();

    private PairResults() {
    }

    public static void addPairResult(ParingInfo paringInfo, PairResult pairResult) {
        pairResults.put(paringInfo, pairResult);
    }

    public static boolean containsMatch(ParingInfo paringInfo) {
        return pairResults.containsKey(paringInfo);
    }

    public static boolean hasSamePairInSameLevel(PairResult result) {
        ParingInfo paringInfo = result.getPairInfo();
        Level level = paringInfo.getLevel();

        List<Set<Crew>> pairsFromSameLevel = getPairsFromSameLevel(level);
        List<Set<Crew>> pairs = result.getPairResult();

        return pairsFromSameLevel.containsAll(pairs);
    }

    private static List<Set<Crew>> getPairsFromSameLevel(Level level) {
        return pairResults.entrySet().stream()
                .filter(entry -> entry.getKey().getLevel() == level)
                .map(Map.Entry::getValue)
                .flatMap(pairResult -> pairResult.getPairResult().stream())
                .collect(Collectors.toList());
    }

    public static void deleteAll() {
        pairResults.clear();
    }
}
