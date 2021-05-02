package calculator.domain;

import calculator.domain.impl.SplitFactory;

public class StringSplitter {
    private Expression expression;

    public StringSplitter(Expression expression) {
        this.expression = expression;
    }

    public Numbers split() {
        SplitFactory splitFactory = new SplitFactory(expression);
        SplitStrategy splitStrategy = splitFactory.getSplitFactory();
        return new Numbers(splitStrategy.splitNumbers(expression.getExpression()));
    }
}
