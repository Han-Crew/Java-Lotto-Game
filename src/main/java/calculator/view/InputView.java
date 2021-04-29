package calculator.view;

import java.util.Scanner;

public class InputView {
    public static String inputExpression() {
        Scanner in = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요.");
        String expression = in.nextLine();
        return expression;
    }
}
