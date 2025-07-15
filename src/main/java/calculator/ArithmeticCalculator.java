package calculator;

public class ArithmeticCalculator extends Calculator{
//// 사칙연산 수행 후 부모의 addResult로 저장
public double calculate(double numOne, double numTow, char giho) {
    if (numOne < 0 || numTow < 0) {
        throw new ArithmeticException("양의정수만 허용합니다.");
    }

    Double result;
    switch (giho) {
        case '+':
            result = numOne + numTow;
            break;
        case '-':
            result = numOne - numTow;
            break;
        case '*':
            result = numOne * numTow;
            break;
        case '/':
            if (numTow == 0) {
                throw new ArithmeticException("나눗셈 연산에서 부모에 0이 입력될 수 없습니다.");
            }
            result = (double) numOne / numTow;
            break;
        default:
            throw new ArithmeticException("지원하지 않는 연산 기호입니다.");
    }
    addResult(result);
    return result;
}

}
