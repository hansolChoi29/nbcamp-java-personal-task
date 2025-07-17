package calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');
    private final char giho;
    OperatorType(char giho){
        this.giho=giho;
    }

    public char getGiho(){
        return giho;
    }
    public static OperatorType fromChar(char ch){
        for(OperatorType op: OperatorType.values()){
            if(op.getGiho()==ch){
                return op;
            }
        }
        throw new ArithmeticException("지원하지 않는 연산자: "+ch);
    }
}
