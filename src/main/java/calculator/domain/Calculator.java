package calculator.domain;

public class Calculator {
    private Numbers numbers;

    public Calculator(Numbers numbers) {
        this.numbers = numbers;
    }

    public int result() {
        int result = 0;
        for (int number : numbers.getNumbers()) {
            result += number;
        }

        return result;
    }
}
