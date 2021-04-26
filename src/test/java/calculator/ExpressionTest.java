package calculator;

import calculator.domain.Expression;
import calculator.utils.ExpressionUtils;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @Test
    public void 숫자_유효성_테스트() {
        String expression = "123";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(true);
    }

    @Test
    public void 콜론_유효성_테스트() {
        String expression = "1:2:3";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(true);
    }

    @Test
    public void 쉼표_유효성_테스트() {
        String expression = "1,2,3";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(true);
    }

    @Test
    public void 콜론_쉼표_유효성_테스트() {
        String expression = "1,2:3";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(true);
    }

    @Test
    public void 다른_문자_유효성_실패_테스트() {
        String expression = "1.2[3";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(false);
    }

    @Test
    public void 알파벳_유효성_실패_테스트() {
        String expression = "a,b:W";
        assertThat(Pattern.matches(ExpressionUtils.PATTERN , expression)).isEqualTo(false);
    }

    @Test
    public void 형식에_맞지_않는_문자열을_넘기면_실패() {
        String 형식에_맞지_않는_문자열 = "1[2]3";
        assertThatThrownBy(() -> new Expression(형식에_맞지_않는_문자열))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 형식에_맞지_않는_문자열을_넘기면_실패2() {
        String 형식에_맞지_않는_문자열 = "AQ,2,3";
        assertThatThrownBy(() -> new Expression(형식에_맞지_않는_문자열))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
