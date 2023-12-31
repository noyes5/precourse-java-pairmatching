package pairmatching.util;

import static pairmatching.util.Constants.MAX_PARING_INFO_SIZE;
import static pairmatching.util.ExceptionMessage.INVALID_COMMAND;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    public static final Pattern NUMBER_ALPHABET_REGEX = Pattern.compile("^[0-9A-Z]+$");
    public static final Pattern HANGLE_REGEX = Pattern.compile("^[가-힇]+$");

    public static void validateInput(String input) {
        if (!NUMBER_ALPHABET_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_COMMAND.getMessage());
        }
    }

    public static void validateParingInput(List<String> input) {
        if (input.size() != MAX_PARING_INFO_SIZE) {
            throw new IllegalArgumentException(INVALID_COMMAND.getMessage());
        }
    }

    public static void validateRematch(String input) {
        if (!HANGLE_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_COMMAND.getMessage());
        }
    }
}
