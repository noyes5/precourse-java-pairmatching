package pairmatching.domain.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.domain.Level;
import pairmatching.domain.PairResult;
import pairmatching.domain.dto.ParingInfo;

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

    public static boolean hasSamePairsInSameLevel(PairResult result) {
        ParingInfo paringInfo = result.getPairInfo();
        Level level = paringInfo.getLevel();

        List<Set<Crew>> pairsFromSameLevel = getPairsFromSameLevel(level);
        List<Set<Crew>> pairs = result.getPairResult();

        Set<Set<Crew>> uniquePairsFromSameLevel = new HashSet<>(pairsFromSameLevel);
        Set<Set<Crew>> uniquePairs = new HashSet<>(pairs);

        return uniquePairs.equals(uniquePairsFromSameLevel);
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

    public static PairResult getByPairingInfo(ParingInfo paringInfo) {
        return pairResults.get(paringInfo);
    }
}
