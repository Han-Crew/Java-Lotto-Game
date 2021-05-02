package calculator.domain;


public class Expression {
    private final String expression;
    private Numbers numbers;

    public Expression(String expression) {
        this.expression = expression;
        this.split();
    }

    private void split() {
        StringSplitter splitter = new StringSplitter(this);
        this.numbers = splitter.split();
    }

    public Numbers getSplitResult() {
        return this.numbers;
    }

    public String getExpression() {
        return expression;
    }
}
