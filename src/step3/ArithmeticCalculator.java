package step3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results;

    public ArithmeticCalculator() {
        this.results = new ArrayList<>();
    }

    public double calculate(T num1, OperatorType operator, T num2) {
        double result = 0;

        switch (operator) {
            case PLUS:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case  MINUS:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
                case DIVIDE:
                    if (num2.doubleValue() == 0) {
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
                    }
                    result = num1.doubleValue()/ num2.doubleValue();
                    break;
        }
        return  result;
    }

    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(double result) {
        this.results.add(result);
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("저장된 결과가 없습니다.");
        }
    }
}