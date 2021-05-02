package calculator;

import calculator.domain.Calculator;
import calculator.domain.Expression;
import calculator.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Nested
    @DisplayName("일반적인 문자열 계산식")
    class DefaultCalculatorTest {
        @Test
        @DisplayName("쉼표로 분리된 문자열 계산식 오면 계산되어야 한다.")
        public void calculation() {
            Expression expression = new Expression("1,2,3");
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(6);
        }

        @Test
        @DisplayName("콜론으로 분리된 문자열 계산식 오면 계산되어야 한다.")
        public void calculation2() {
            Expression expression = new Expression("1:2:3");
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(6);
        }

        @Test
        @DisplayName("쉼표와 콜론으로 분리된 문자열 계산식 오면 계산되어야 한다.")
        public void calculation3() {
            Expression expression = new Expression("1,2:3,4");
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(10);
        }

        @Test
        @DisplayName("쉼표와 콜론외의 문자로 분리된 문자열 계산식 오면 에러가 발생되어야 한다.")
        public void calculation4() {
            String 형식에_맞지_않는_문자열 = "1;2:3[4";
            assertThatThrownBy(() -> new Expression(형식에_맞지_않는_문자열))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("커스텀 문자열 계산식")
    class CustomCalculatorTest {
        @Test
        @DisplayName("커스텀 문자로 분리된 문자열 계산식이 오면 계산되어야 한다.")
        public void calculation() {
            String 커스텀_문자열 = "//]\n3]7]5";
            Expression expression = new Expression(커스텀_문자열);
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(15);
        }

        @Test
        @DisplayName("커스텀 문자로 분리된 문자열 계산식이 오면 계산되어야 한다2.")
        public void calculation2() {
            String 커스텀_문자열 = "//p\n3p7p5";
            Expression expression = new Expression(커스텀_문자열);
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(15);
        }
    }

    @Nested
    @DisplayName("공백 문자열 계산식")
    class BlankCalculatorTest {
        @Test
        @DisplayName("공백 문자열 계산식이 오면 0을 리턴해야 한다.")
        public void calculation() {
            Expression expression = new Expression("");
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("하나의 숫자만 가진 문자열 계산식")
    class SingleNumberCalculatorTest {
        @Test
        @DisplayName("하나의 숫자만 가진 문자열 계산식이 오면 그대로 리턴해야 한다.")
        public void calculation() {
            Expression expression = new Expression("5");
            Numbers numbers = expression.getSplitResult();
            Calculator calculator = new Calculator(numbers);
            assertThat(calculator.result()).isEqualTo(5);
        }
    }

    @Nested
    @DisplayName("잘못된 형식의 문자열 계산식")
    class ExceptionTest {
        @Test
        @DisplayName("계산식에 음수가 포함되면 에러가 발생해야 한다.")
        public void calculation() {
            String 음수가_포함된_문자열 = "-1,2,3";
            assertThatThrownBy(() -> new Expression(음수가_포함된_문자열))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("계산식에 9 초과된 수가 포함되면 에러가 발생해야 한다.")
        public void calculation2() {
            String 초과된_숫자가_포함된_문자열 = "1,2,11";
            assertThatThrownBy(() -> new Expression(초과된_숫자가_포함된_문자열))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        @DisplayName("커스텀 문자열의 커스텀 문자가 다르면 에러가 발생해야 한다.")
        public void calculation3() {
            String 잘못된_형식의_커스텀_문자열 = "//[\n1[2]3";
            assertThatThrownBy(() -> new Expression(잘못된_형식의_커스텀_문자열))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}
