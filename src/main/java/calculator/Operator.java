package calculator;

public interface Operator {

    // 인터페이스란?
    // 설계도 또는 약속.

    // 클래스들이 반드시 구현해야 하는 implement 메서드 틀을 정의한다.
    // 직접 구현은 하지 않고 메서드 시그니처(이름, 매개변수,반환타입)만 선언해야 한다.

    // 실제 동작은 이 인터페이스를 구현한 클래스에서 정의해야 한다.

    // 연산자 기호를 반환하는 메서드
    char getSymbol();

    // 실제 연산을 수행하는 메서드
    // a, b 두 숫자를 받아서 연산 결과(double)를 반환함
    double operator(double a, double b);
}
