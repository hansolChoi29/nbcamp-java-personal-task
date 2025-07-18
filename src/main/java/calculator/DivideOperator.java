package calculator;
// 나눗셈 기능을 담당하는 클래스
// Operator 인터페이스를 구현하여 '/' 연산을 처리함
public class DivideOperator implements Operator{

    // 연산 기호를 반환하는 메서드: '/' 리턴
    @Override
    public char getSymbol() {
        return '/';
    }

    // 두 수를 나눈 결과를 반환하는 메서드 (a / b)
    // 단, b가 0이면 ArithmeticException 예외 발생
    @Override
    public double operator(double a, double b) {
        if(b==0){
            throw new ArithmeticException("나눗셈 연산에서 0이 입력될 수 없습니다.");
        }return a/b;
    }
}
