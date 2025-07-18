package calculator;
// 열거형(enum)을 사용해 연산자 타입을 정의함
// ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD 다섯 가지 연산을 나타냄
public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');

    // 각 연산자 타입이 가지는 실제 문자 기호를 저장할 필드
    private final char giho;

    // 생성자: enum 상수가 정의될 때마다 해당 문자 기호를 함께 저장
    OperatorType(char giho){
        this.giho=giho;
    }

    // 외부에서 해당 연산자의 기호를 읽어올 수 있도록 getter 제공
    public char getGiho(){
        return giho;
    }

    // 입력된 문자 기호(char ch)를 받아, 어떤 OperatorType에 해당하는지 찾아서 반환
    // 예: '+' 입력 → OperatorType.ADD 반환
    public static OperatorType fromChar(char ch){
        for(OperatorType op: OperatorType.values()){
            if(op.getGiho()==ch){
                return op;
            }
        }

        // 위 반복문에서 아무것도 매칭되지 않으면 예외 발생 (지원하지 않는 연산자라는 뜻)
        throw new ArithmeticException("지원하지 않는 연산자: "+ch);
    }
}
