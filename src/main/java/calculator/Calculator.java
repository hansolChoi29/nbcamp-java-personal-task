package calculator;

import java.util.ArrayList;
import java.util.List;

//결과 값을 반환하는 메서드와
//연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스
public class Calculator {
   private final List<Integer> results=new ArrayList<>();

    public int calculate(int numOne, int numTow ,char giho) {
        if (numOne < 0 || numTow < 0) {
            throw new ArithmeticException("양의정수만 허용합니다.");
        }

        int result;
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
                    throw  new ArithmeticException("나눗셈 연산에서 부모에 0이 입력될 수 없습니다.");
                }
                result = numOne / numTow;
                break;
            default:
               throw new ArithmeticException("지원하지 않는 연산 기호입니다.");
        }
        results.add(result);
        return result;
    }
}
