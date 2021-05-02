package calculator.domain.impl;

import calculator.domain.SplitStrategy;
import calculator.utils.NumbersUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSplitStrategy implements SplitStrategy {
    @Override
    public List<Integer> splitNumbers(String expression) {
        List<Integer> numbers = new ArrayList<>();
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            numbers = Arrays.stream(
                    matcher.group(2).split(customDelimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        NumbersUtils.validateNumbers(numbers);
        return numbers;
    }
}