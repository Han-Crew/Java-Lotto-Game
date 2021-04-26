package calculator.domain;


public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = getExpressionAndEmptyCheck(expression);
    }

    private String getExpressionAndEmptyCheck(String expression) {
        if (expression == null || "".equals(expression)) {
            return "0";
        }

        return expression;
    }

    public String getExpression() {
        return expression;
    }
}
