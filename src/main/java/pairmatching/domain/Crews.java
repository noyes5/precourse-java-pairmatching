package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.INVALID_CREW_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static void deleteAll() {
        crews.clear();
    }

    public static Crew findCrewByName(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CREW_NAME.getMessage()));
    }
}
