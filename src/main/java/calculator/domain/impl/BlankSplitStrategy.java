package calculator.domain.impl;

import calculator.domain.SplitStrategy;

import java.util.List;

public class BlankSplitStrategy implements SplitStrategy {
    @Override
    public List<Integer> splitNumbers(String expression) {
        return List.of(0);
    }
}
