package step1;

import java.util.Scanner;

public class App {

    static void main() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            if (num1 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            if (num2 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            int result = 0;

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue; //자동완성해주었다.
                }
                result = num1 / num2;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요");
                continue;
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}
