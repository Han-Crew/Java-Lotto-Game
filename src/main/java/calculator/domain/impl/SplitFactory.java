package calculator.domain.impl;

import calculator.domain.Expression;
import calculator.domain.SplitStrategy;
import calculator.utils.ExpressionUtils;

public class SplitFactory {
    private Expression expression;
    public SplitFactory(Expression expression) {
        this.expression = expression;
    }

    public SplitStrategy getSplitFactory() {
        String expressionStr = expression.getExpression();
        if (ExpressionUtils.isDefaultExpression(expressionStr)) {
            return new DefaultSplitStrategy();
        } else if (ExpressionUtils.isCustomExpression(expressionStr)) {
            return new CustomSplitStrategy();
        } else if (ExpressionUtils.isSingleNumberExpression(expressionStr)) {
            return new SingleNumberStrategy();
        } else if (ExpressionUtils.isBlankOrNullExpression(expressionStr)) {
            return new BlankSplitStrategy();
        }

        return null;
    }
}
