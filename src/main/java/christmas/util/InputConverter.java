package christmas.util;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    private static final String DELIMITER = ",";

    private InputConverter() {
    }

    public static Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }

    public static List<String> convertStringToListByDelimiter(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
