package calculator.domain.impl;

import calculator.domain.SplitStrategy;
import java.util.List;

public class SingleNumberStrategy implements SplitStrategy {

    @Override
    public List<Integer> splitNumbers(String expression) {
        return List.of(Integer.parseInt(expression));
    }
}
