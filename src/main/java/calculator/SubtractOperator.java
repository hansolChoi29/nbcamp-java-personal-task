package calculator;

public class SubtractOperator implements Operator{

    // 뺄셈 연산을 담당하는 클래스
    // 연산 기호를 반환하는 메서드
    @Override
    public char getSymbol() {
        return'-';
    }
    // a - b 결과를 반환
    @Override
    public double operator(double a, double b) {
        return  a-b;
    }
}
