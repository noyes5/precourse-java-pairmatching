package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.INVALID_CREW_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.repository.Crew;

public class Crews {
    private static final List<Crew> crews = new ArrayList<>();

    private Crews() {
    }

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static Crew findCrewByName(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CREW_NAME.getMessage()));
    }

    public static List<Crew> findCrewsByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.Of(course))
                .collect(Collectors.toList());
    }
}
