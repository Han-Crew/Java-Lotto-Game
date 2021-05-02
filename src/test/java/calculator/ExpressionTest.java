package calculator;

import calculator.domain.Expression;
import calculator.utils.ExpressionUtils;
import calculator.utils.NumbersUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @Nested
    @DisplayName("숫자,특수문자 경우의 유효성 체크")
    class ValidationTest {

        @Test
        public void 숫자만_넘긴경우_실패해야한다() {
            String expression = "123";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(false);
        }

        @Test
        public void 콜론_유효성_테스트() {
            String expression = "1:2:3";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(true);
        }

        @Test
        public void 쉼표_유효성_테스트() {
            String expression = "1,2,3";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(true);
        }

        @Test
        public void 콜론_쉼표_유효성_테스트() {
            String expression = "1,2:3";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(true);
        }

        @Test
        public void 다른_문자_유효성_실패_테스트() {
            String expression = "1.2[3";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(false);
        }

        @Test
        public void 알파벳_유효성_실패_테스트() {
            String expression = "a,b:W";
            assertThat(ExpressionUtils.isDefaultExpression(expression)).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("형식에 맞지 않는 문자열 실패 테스트")
    class ValidationFailTest {
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

    @Nested
    @DisplayName("커스텀 문자열 테스트")
    class CustomValidationTest {
        @Test
        public void 커스텀_문자열_테스트() {
            String 커스텀_문자열 = "//;\n3;5;1";
            assertThat(ExpressionUtils.isCustomExpression(커스텀_문자열)).isEqualTo(true);
        }

        @Test
        public void 커스텀_문자열_테스트2() {
            String 커스텀_문자열 = "//]\n3]5]1";
            assertThat(ExpressionUtils.isCustomExpression(커스텀_문자열)).isEqualTo(true);
        }
    }
}
