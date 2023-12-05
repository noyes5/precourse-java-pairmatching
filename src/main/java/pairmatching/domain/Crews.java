package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private static final List<Crew> crews = new ArrayList<>();

    private Crews() {
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

}
