package calculator.utils;

import java.util.List;

public class NumbersUtils {
    public static void validateNumbers(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < 0 || number > 9) {
                throw new RuntimeException();
            }
        });
    }
}
