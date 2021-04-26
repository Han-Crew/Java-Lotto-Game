package calculator.domain;

import calculator.utils.ExpressionUtils;

import java.util.regex.Pattern;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        expressionValidationCheck(expression);
        this.expression = expression;
    }

    private void expressionValidationCheck(String expression) {
        if (!Pattern.matches(ExpressionUtils.PATTERN , expression)) {
            throw new IllegalArgumentException("형식에 맞지 않는 문자열입니다.");
        }
    }

}
