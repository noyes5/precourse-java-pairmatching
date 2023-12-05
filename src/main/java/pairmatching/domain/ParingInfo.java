package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.NO_MISSION_IN_LEVEL;

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
}
