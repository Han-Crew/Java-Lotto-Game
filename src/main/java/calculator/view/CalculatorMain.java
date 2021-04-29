package calculator.view;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.StringSplitter;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InputView.inputExpression();
        Expression expression = new Expression(input);
        StringSplitter splitter = new StringSplitter(expression);
        Calculator calculator = new Calculator(splitter.split());
        ResultView.printResult(calculator.result());
    }
}
