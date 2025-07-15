package calculator;

public class ModOperator implements Operator{
    // ArithmeticCalculator 클래스에
    //추가로 나머지 연산(%) 기능을 추가하기 위해 ModOperator 클래스를 만들어 추가합니다.

    // 문제의 핵심: 새로운 연산%을 추가할 때마다 기존 코드를 여기저기 고치는 게아니라
    // 확장은 가능, 수정x => SOLID원칙 중 OCP
    // Open for extension: 새 연산을 추가할 수 있어야 함
    // Closed for modification: 기존 코드는 손대지 않아도 돼야 한다.

    @Override
    public char getSymbol() {
        return '%';
    }

    @Override
    public double operator(double a, double b) {
        if(b==0){
            throw  new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a%b;
    }



}
