package step2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1;
            try {
                num1 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해야 합니다.");
                continue;
            }
            if (num1 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            char operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operatorInput = sc.nextLine();

                if (operatorInput.length() != 1) {
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    continue;
                }

                operator = operatorInput.charAt(0);

                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요");
                    continue;
                }
                break;
            }

            int num2;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                try {
                    num2 = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력해야 합니다.");
                    continue;
                }
                if (num2 < 0) {
                    System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                    continue;
                }
                if (num2 == 0 && operator == '/') {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                break;
            }

            int result = calculator.calculate(num1, operator, num2);
            System.out.println("결과: " + result);
        }
    }
}
