package pairmatching.domain;

import static pairmatching.util.ExceptionMessage.INVALID_COURSE_NAME;
import static pairmatching.util.ExceptionMessage.INVALID_LEVEL_NAME;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.command.MainCommand;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String input) {
        return Arrays.stream(Level.values())
                .filter(command -> command.name.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LEVEL_NAME.getMessage()));
    }
}
