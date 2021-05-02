package calculator;

import calculator.domain.Expression;
import calculator.domain.Numbers;
import calculator.utils.NumbersUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

    @Test
    public void 음수가_포함된_문자열을_넘기면_실패() {
        String 음수가_포함된_문자열 = "-1,2,3";
        assertThatThrownBy(() -> new Expression(음수가_포함된_문자열))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 음수가_포함된_리스트를_넘기면_실패() {
        List<Integer> 음수가_포함된_리스트 = List.of(-1,2,3);
        assertThatThrownBy(() -> NumbersUtils.validateNumbers(음수가_포함된_리스트))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 0 ~ 9 가 아닌 경우의 문자열인 경우 RuntimeException 이 발생해야 한다")
    public void createNumbers() {
        List<Integer> 숫자가_0_미만 = List.of(-1 , 2 , 3);

        assertThatThrownBy(() -> new Numbers(숫자가_0_미만))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 0 ~ 9 가 아닌 경우의 문자열인 경우 RuntimeException 이 발생해야 한다")
    public void createNumbers2() {
        List<Integer> 숫자가_9_초과 = List.of(1 , 2 , 12);

        assertThatThrownBy(() -> new Numbers(숫자가_9_초과))
                .isInstanceOf(RuntimeException.class);
    }
}
