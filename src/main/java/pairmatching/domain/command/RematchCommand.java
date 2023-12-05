package pairmatching.domain.command;

import static pairmatching.util.ExceptionMessage.INVALID_COMMAND;

import java.util.Arrays;

public enum RematchCommand {
    YES("네"), NO("아니오");

    private final String command;

    RematchCommand(String command) {
        this.command = command;
    }

    public static RematchCommand from(String command) {
        return Arrays.stream(RematchCommand.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND.getMessage()));
    }

    public boolean isNo() {
        return this == NO;
    }
}
