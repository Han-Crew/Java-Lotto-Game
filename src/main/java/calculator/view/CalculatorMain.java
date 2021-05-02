package calculator.view;

import calculator.domain.Calculator;
import calculator.domain.Expression;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InputView.inputExpression();
        Expression expression = new Expression(input);
        Calculator calculator = new Calculator(expression.getSplitResult());
        ResultView.printResult(calculator.result());
    }
}
