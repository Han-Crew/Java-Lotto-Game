package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionUtils {
    public static final String PATTERN = "^[0-9:,]*$";
    public static final String CUSTOM_SPLIT_PATTERN = "//(.)\n(.*)";

    public static boolean isRightExpression(String expression) {
        return Pattern.matches(PATTERN , expression);
    }

    public static boolean isCustomExpression(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(expression);
        return matcher.find();
    }

    public static Matcher getCustomMatch(String expression) {
        return Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(expression);
    }
}
