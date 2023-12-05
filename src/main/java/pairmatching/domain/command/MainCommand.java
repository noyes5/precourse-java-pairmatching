package pairmatching.domain.command;

import static pairmatching.util.ExceptionMessage.ERROR_MAIN_COMMAND;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainCommand {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_SEARCHING("2", "페어 조회"),
    PAIR_INITIALIZING("3", "페어 초기화"),
    APPLICATION_EXIT("Q", "종료");

    private final String command;
    private final String display;

    MainCommand(String command, String display) {
        this.command = command;
        this.display = display;
    }

    public static MainCommand from(String input) {
        return Arrays.stream(MainCommand.values())
                .filter(command -> command.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MAIN_COMMAND.getMessage()));
    }

    public static List<String> getFormatedList() {
        return Arrays.stream(MainCommand.values())
                .map(it -> String.format("%s. %s", it.command, it.display))
                .collect(Collectors.toList());
    }
}
