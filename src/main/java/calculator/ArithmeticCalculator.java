package calculator;

import java.util.List;

//public class ArithmeticCalculator extends Calculator {
public class ArithmeticCalculator<T extends Number> extends Calculator {
//    private final AddOperator opAdd;
//    private final SubtractOperator opSub;
//    private final MultiplyOperator opMul;
//    private final DivideOperator opDiv;
//
//    public ArithmeticCalculator(AddOperator opAdd, SubtractOperator opSub, MultiplyOperator opMul, DivideOperator opDiv) {
//        this.opAdd = opAdd;
//        this.opDiv = opDiv;
//        this.opSub = opSub;
//        this.opMul = opMul;
//    }
    //위 코드를 없앤 이유, AddOperator, SubtractOperator... 4개를 개별 필드로 두면
    // 나머지 %같은 새 연산을 추가할 때마다
    //1) 필드 선언 더 늘려야 하고
    //2) 생성자 시그니처에도 매개변수를 계속 추가해야 하며
    //3) calculator()내부의 switch 나 if로직에도 조건을 하나씩 더 붙여햐 하기 때문에
    //이럴 경우 매번 기존 코드를 수정해야 하고 클래스가 점점 비대해진다.
    private final Operator[] ops;
    public ArithmeticCalculator(Operator[] ops){
        this.ops=ops;
    }
    /// / 사칙연산 수행 후 부모의 addResult로 저장
//    public double calculate(double numOne, double numTow, char giho) {
    public double calculate(T numOne, T numTow, char giho){
        double a=numOne.doubleValue();
        double b=numTow.doubleValue();
//        if (numOne < 0 || numTow < 0) {

        if(a<0||b<0){
            throw new ArithmeticException("양의정수만 허용합니다.");
        }
        OperatorType type=OperatorType.fromChar(giho);
        for (Operator op : ops) {
            if (op.getSymbol() == type.getGiho()) {
//                double result = op.operator(numOne, numTow);
                double result=op.operator(a,b);
                addResult(result);
                return result;
            }
        }
        throw new ArithmeticException("지원하지 않는 연산 기호입니다.");
    }
}
