package calculator;

public class DivideOperator implements Operator{


    @Override
    public char getSymbol() {
        return '/';
    }

    @Override
    public double operator(double a, double b) {
        if(b==0){
            throw new ArithmeticException("나눗셈 연산에서 0이 입력될 수 없습니다.");
        }return a/b;
    }
}
