package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.domain.repository.Crews;

public class PairResult {
    private final ParingInfo paringInfo;
    private final List<Set<Crew>> pairResult;

    public PairResult(ParingInfo paringInfo) {
        this.paringInfo = paringInfo;
        this.pairResult = pairProcess();
    }

    private List<Set<Crew>> pairProcess() {
        List<Crew> crews = Crews.findCrewsByCourse(paringInfo.getCourse());
        List<Crew> shuffledCrews = getShuffleCrew(crews);
        if (shuffledCrews.size() % 2 == 0) {
            return handleEvenCrews(shuffledCrews);
        }
        return handleOddCrews(shuffledCrews);
    }

    private static List<Crew> getShuffleCrew(List<Crew> crews) {
        return Randoms.shuffle(getCrewName(crews)).stream()
                .map(Crews::findCrewByName)
                .collect(Collectors.toList());
    }

    private List<Set<Crew>> handleEvenCrews(List<Crew> shuffledCrews) {
        List<Set<Crew>> result = new ArrayList<>();

        for (int index = 0; index < shuffledCrews.size(); index += 2) {
            Set<Crew> pair = new LinkedHashSet<>(Arrays.asList(shuffledCrews.get(index), shuffledCrews.get(index + 1)));
            result.add(pair);
        }
        return result;
    }

    private List<Set<Crew>> handleOddCrews(List<Crew> shuffledCrews) {
        List<Set<Crew>> result = new ArrayList<>();

        for (int index = 0; index < shuffledCrews.size() - 2; index += 2) {
            Set<Crew> pair = new LinkedHashSet<>(Arrays.asList(shuffledCrews.get(index), shuffledCrews.get(index + 1)));
            result.add(pair);
        }
        Set<Crew> lastCrews = new LinkedHashSet<>(Arrays.asList(
                shuffledCrews.get(shuffledCrews.size() - 3),
                shuffledCrews.get(shuffledCrews.size() - 2),
                shuffledCrews.get(shuffledCrews.size() - 1)
        ));
        result.add(lastCrews);
        return result;
    }

    private static List<String> getCrewName(List<Crew> crews) {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }


    public List<Set<Crew>> getPairResult() {
        return Collections.unmodifiableList(pairResult);
    }

    public ParingInfo getPairInfo() {
        return this.paringInfo;
    }
}


