package step3;

import java.util.List;
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
                System.out.println("숫자를 입력해야 합니다.");
                continue;
            }
            if (num1 < 0) {
                System.out.println("잘못된 숫자입니다. 양의 숫자만 입력해주세요");
                continue;
            }
            if (Double.isInfinite(num1) || Double.isNaN(num1)) {
                System.out.println("유효하지 않은 숫자입니다.");
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
                    num2 = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해야 합니다.");
                    continue;
                }
                if (num2 < 0) {
                    System.out.println("잘못된 숫자입니다. 양의 숫자만 입력해주세요");
                    continue;
                }
                if (Double.isInfinite(num2) || Double.isNaN(num2)) {
                    System.out.println("유효하지 않은 숫자입니다.");
                    continue;
                }
                if (operator == OperatorType.DIVIDE && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                break;
            }

            try {
                double result = calculator.calculate(num1, operator, num2);

                calculator.setResult(result);

                System.out.println("결과: " + result);
                System.out.println("저장된 결과: " + calculator.getResults());

                System.out.print("특정 값보다 큰 결과만 조회하시겠습니까? (숫자 입력 시 조회, 그 외 입력 시 넘어가기): ");
                String filterInput = sc.nextLine();
                try {
                    double standard = Double.parseDouble(filterInput);
                    List<Double> filteredResults = calculator.getResultsGreaterThan(standard);
                    System.out.println(standard + "보다 큰 결과: " + filteredResults);
                } catch (NumberFormatException e) {
                }
            } catch (ArithmeticException e) {
                System.out.println("계산 오류: " + e.getMessage());
                continue;
            }

            while (true) {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, remove 입력 시 가장 먼저 저장된 결과 삭제, biggerthan 입력 시 조회, 다른 값 입력 시 계속)");
                String command = sc.nextLine();
                if (command.equals("exit")) {
                    sc.close();
                    return;
                } else if (command.equals("remove")) {
                    calculator.removeResult();
                    System.out.println("저장된 결과: " + calculator.getResults());
                } else if (command.equals("biggerthan")) {
                    System.out.print("기준값을 입력하세요: ");
                    try {
                        double standard = Double.parseDouble(sc.nextLine());
                        List<Double> filteredResults = calculator.getResultsGreaterThan(standard);
                        System.out.println(standard + "보다 큰 결과: " + filteredResults);
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 숫자를 입력하세요.");
                    }
                } else {
                    break;
                }
            }
        }
    }
}