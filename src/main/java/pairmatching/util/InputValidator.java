package pairmatching.util;

import static pairmatching.util.ExceptionMessage.INVALID_COMMAND;

import java.util.regex.Pattern;

public class InputValidator {
    public static final Pattern NUMBER_ALPHABET_REGEX = Pattern.compile("^[0-9A-Z]+$");

    public static void validateInput(String input) {
        if (!NUMBER_ALPHABET_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_COMMAND.getMessage());
        }
    }
}
