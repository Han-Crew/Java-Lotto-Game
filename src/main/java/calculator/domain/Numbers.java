package calculator.domain;

import java.util.Collections;
import java.util.List;

public class Numbers {
    public List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
