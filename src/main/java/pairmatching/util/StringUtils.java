package pairmatching.util;

import static pairmatching.util.ExceptionMessage.INVALID_INPUT_BLANK;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, NO_SPACE);
    }

    public static List<String> splitByComma(String input) {
        return Arrays.asList(removeSpace(input).split(COMMA));
    }
}
