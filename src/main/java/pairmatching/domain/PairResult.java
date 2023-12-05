package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class PairResult {
    List<Crew> pairResult;

    public PairResult(List<Crew> pairResult) {
        this.pairResult = pairProcess();
    }

    private List<Crew> pairProcess() {
        List<Crew> crews = Crews.crews();
        List<Crew> shuffledCrews = getShuffleCrew(crews);
        pairResult = shuffledCrews;
    }

    private static List<Crew> getShuffleCrew(List<Crew> crews) {
        return Randoms.shuffle(getCrewName(crews)).stream()
                .map(Crews::findCrewByName)
                .collect(Collectors.toList());
    }

    private static List<String> getCrewName(List<Crew> crews) {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }

}


