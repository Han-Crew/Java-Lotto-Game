package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static calculator.utils.ExpressionUtils.*;

public class StringSplitter {
    private Expression expression;
    private List<Integer> numbers;

    public StringSplitter(Expression expression) {
        this.expression = expression;
        this.numbers = initNumbers();
    }

    public List<Integer> initNumbers() {
        String expressionStr = expression.getExpression();
        if (isCustomExpression(expressionStr)) {
            return getCustomExpressionNumbers(expressionStr);
        }

        return getExpressionNumbers();
    }

    private List<Integer> getExpressionNumbers() {
        return null;
    }

    private List<Integer> getCustomExpressionNumbers(String expression) {
        Matcher matcher = getCustomMatch(expression);
        String customSymbol = matcher.group(1);
        return this.numbers = Arrays.stream(
                matcher.group(2).split(customSymbol))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
