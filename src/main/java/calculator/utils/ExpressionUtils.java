package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionUtils {
    public static final String PATTERN = "^[0-9:|,]*$";
    public static final String CUSTOM_SPLIT_PATTERN = "//(.)\\n(.*)";

    public static boolean isDefaultExpression(String expression) {
        boolean symbolContains = expression.contains(",") || expression.contains(":");
        return Pattern.matches(PATTERN , expression) && symbolContains;
    }

    public static boolean isCustomExpression(String expression) {
        return Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(expression).find();
    }

    public static boolean isSingleNumberExpression(String expression) {
        return expression.length() == 1;
    }

    public static boolean isBlankOrNullExpression(String expression) {
        return expression == null || expression.isEmpty();
    }
}
