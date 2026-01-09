package step3;

import step2.Calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1;
            try {
                num1 = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해야 합니다.");
                continue;
            }
            if (num1 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 정수만 입력해주세요");
                continue;
            }

            OperatorType operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operatorInput = sc.nextLine();

                if (operatorInput.length() != 1) {
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    continue;
                }

                operator = OperatorType.fromSymbol(operatorInput.charAt(0));

                if (operator == null) {
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요");
                    continue;
                }
                break;
            }

            double num2;
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
                if (Double.isInfinite(num2) || Double.isNaN(num2)) {
                    System.out.println("유효하지 않은 숫자입니다.");
                    continue;
                }
                if (num2 == 0 && operator == OperatorType.DIVIDE) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                break;
            }

            try{
                double result = calculator.calculate(num1, operator, num2);

                calculator.setResults(result);
                System.out.println("결과: " + result);
                System.out.println("저장된 결과: " + calculator.getResults());
            } catch (ArithmeticException e) {
                System.out.println("계산 오류");
                continue;
            }



            while (true) {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, remove 입력 시 가장 먼저 저장된 결과 삭제, 다른 값 입력 시 계속)");
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    sc.close();
                    return;
                } else if (command.equals("remove")) {
                    calculator.removeResult();
                    System.out.println("저장된 결과: " + calculator.getResults());
                } else {
                    break;
                }
            }
        }
    }
}