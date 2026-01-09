package step1;

import java.util.Scanner;

public class App {

    static void main() {
        Scanner sc = new Scanner(System.in);

        //TODO: step3에서 예외처리 및 nextLine으로 받기, 필요시 형변환, 각 단계별 목표치 정하고 개발시작하기
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            if (num1 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            char operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operatorInput = sc.next();

                if (operatorInput.length() != 1) {
                    System.out.println("올바를 사칙연산 기로를 입력하세요.");
                    continue;
                }

                operator = operatorInput.charAt(0);

                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요");
                    continue;
                }
                break;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            if (num2 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            int result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
            }// 자동완성이 많은것을 해주었다...

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, 다른 값 입력 시 계속)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        sc.close();
    }
}
