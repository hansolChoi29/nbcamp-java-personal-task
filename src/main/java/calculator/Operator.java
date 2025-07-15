package calculator;

public interface Operator {
    char getSymbol();
    //실제 연산 수행하는 코드
    double operator(double a, double b);
}
