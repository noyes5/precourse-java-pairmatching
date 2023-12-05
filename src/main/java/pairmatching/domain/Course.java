package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.INVALID_COURSE_NAME;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(Course.values())
                .filter(command -> command.name.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_NAME.getMessage()));
    }

}
