package calculator;

// 덧셈 기능을 담당하는 클래스
// Operator 인터페이스를 구현하여 '+' 연산을 처리함
public class AddOperator implements Operator{

    // 연산 기호를 반환하는 메서드: '+' 리턴
    @Override
    public char getSymbol() {
        return '+';
    }

    // 두 수를 더한 값을 반환하는 메서드
    @Override
    public double operator(double a, double b) {
        return a+b;
    }
}
