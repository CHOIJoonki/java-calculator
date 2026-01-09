package step2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public int calculate(int num1, char operator, int num2) {
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
                result = num1 / num2;
                break;
        }
        results.add(result);
        return result;
    }
}