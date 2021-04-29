package calculator.domain.impl;

import calculator.domain.SplitStrategy;
import calculator.utils.NumbersUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSplitStrategy implements SplitStrategy {

    @Override
    public List<Integer> splitNumbers(String expression) {
        String token[] = expression.split(",|:");
        List<Integer> numbers = Arrays.stream(token).map(Integer::parseInt).collect(Collectors.toList());

        NumbersUtils.validateNumberSize(numbers);
        return numbers;
    }
}
