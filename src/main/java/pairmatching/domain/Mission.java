package pairmatching.domain;

import java.util.Objects;

public class Mission {
    private final String name;
    private Level level;

    public Mission(String name) {
        this.name = name;
    }

    public Mission(String name, Level level) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission = (Mission) o;
        return Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "name='" + name + '\'' +
                '}';
    }
}
