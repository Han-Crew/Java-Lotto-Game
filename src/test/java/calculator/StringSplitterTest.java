package calculator;

import calculator.domain.Expression;
import calculator.domain.SplitStrategy;
import calculator.domain.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSplitterTest {
    SplitStrategy getSplitStrategy(String expression) {
        SplitFactory splitFactory = new SplitFactory(new Expression((expression)));
        return splitFactory.getSplitStrategy();
    }

    @Nested
    @DisplayName("일반적인 문자열 계산식 자르기")
    class ExpressionSplitTest {

        @Test
        @DisplayName("쉼표로 분리된 경우 new DefaultSplitStrategy 를 리턴받아야 한다")
        public void split() {
            String expression = "1,2,3";

            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new DefaultSplitStrategy().getClass());
        }

        @Test
        @DisplayName("콜론으로 분리된 경우 new DefaultSplitStrategy 를 리턴받아야 한다")
        public void split2() {
            String expression = "1:2:3";

            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new DefaultSplitStrategy().getClass());
        }

        @Test
        @DisplayName("쉼표와 콜론으로 분리된 경우 new DefaultSplitStrategy 를 리턴받아야 한다")
        public void split3() {
            String expression = "1,2:3";

            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new DefaultSplitStrategy().getClass());
        }
    }

    @Nested
    @DisplayName("커스텀 문자열 계산식 자르기")
    class CustomExpressionSplitTest {

        @Test
        @DisplayName("커스텀 문자열의 경우(a) new CustomSplitStrategy 를 리턴받아야 한다")
        public void split() {
            String expression = "//a\n1a2a3";
            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new CustomSplitStrategy().getClass());
        }

        @Test
        @DisplayName("커스텀 문자열의 경우(;) new CustomSplitStrategy 를 리턴받아야 한다")
        public void split2() {
            String expression = "//;\n1;2;3";
            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new CustomSplitStrategy().getClass());
        }
    }

    @Nested
    @DisplayName("빈 문자열 자르기")
    class BlankExpressionSplitTest {

        @Test
        @DisplayName("계산식이 공백 인 경우 new BlankSplitStrategy 를 리턴받아야 한다")
        public void split2() {
            String expression = "";
            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new BlankSplitStrategy().getClass());
        }
    }

    @Nested
    @DisplayName("숫자 하나만 있는 문자열 자르기")
    class SingleNumberSplitTest {

        @Test
        @DisplayName("숫자가 하나만 있는 문자열인 경우 new SingleNumberStrategy 를 리턴받아야 한다")
        public void split() {
            String expression = "5";
            SplitStrategy splitStrategy = getSplitStrategy(expression);
            assertThat(splitStrategy.getClass()).isEqualTo(new SingleNumberStrategy().getClass());
        }
    }
}
