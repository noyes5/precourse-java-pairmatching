package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.NO_MISSION_IN_LEVEL;

import java.util.Objects;
import pairmatching.domain.repository.Missions;

public class ParingInfo {
    private Course course;
    private Level level;
    private Mission mission;

    public ParingInfo(Course course, Level level, Mission mission) {
        isLevelHasMission(level, mission);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    private void isLevelHasMission(Level level, Mission mission) {
        if (!Missions.hasLevel(level, mission)) {
            throw new IllegalArgumentException(NO_MISSION_IN_LEVEL.getMessage());
        }
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParingInfo that = (ParingInfo) o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    @Override
    public String toString() {
        return "ParingInfo{" +
                "course=" + course +
                ", level=" + level +
                ", mission=" + mission +
                '}';
    }
}
