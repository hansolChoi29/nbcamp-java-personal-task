package calculator;

public class AddOperator implements Operator{


    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double operator(double a, double b) {
        return a+b;
    }
}
