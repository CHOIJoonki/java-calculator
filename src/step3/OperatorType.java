package step3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType operator : values()) {
            if (operator.symbol == symbol) {
                return operator;
            }
        }
        return null;
    }
}

