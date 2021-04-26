package calculator.domain;

import calculator.utils.ExpressionUtils;
import static calculator.utils.ExpressionUtils.isRightExpression;

public class Expression {
    public static final String CUSTOM_SPLIT_PATTERN = "//(.)\n(.*)";
    private final String expression;

    public Expression(String expression) {
        expressionValidationCheck(expression);
        this.expression = getExpressionAndEmptyCheck(expression);
    }

    private void expressionValidationCheck(String expression) {
        if (!isRightExpression(expression) && !ExpressionUtils.isCustomExpression(expression)) {
            throw new IllegalArgumentException("형식에 맞지 않는 문자열입니다.");
        }
    }

    private String getExpressionAndEmptyCheck(String expression) {
        if (expression == null || "".equals(expression)) {
            return "0";
        }

        return expression;
    }
}
