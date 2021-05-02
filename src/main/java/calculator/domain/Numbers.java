package calculator.domain;

import calculator.utils.NumbersUtils;

import java.util.Collections;
import java.util.List;

public class Numbers {
    public List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        NumbersUtils.validateNumbers(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
