package calculator.domain;

import java.util.List;

@FunctionalInterface
public interface SplitStrategy {
    List<Integer> splitNumbers(String expression);
}
