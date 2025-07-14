package calculator;

import java.util.ArrayList;
import java.util.List;

//결과 값을 반환하는 메서드와
//연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스
public class Calculator {
    private final List<Double> results = new ArrayList<>();

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
        results.add(result);
        return result;
    }

    //게터: 내부 리스트 읽기 전용
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    //세터: 외부에서 전달된 리스트
    public void setResults(List<Double> newResults) {
        results.clear();
        results.addAll(newResults);
    }

    //삭제
    public Double removeTodo() {
        if (results.isEmpty()) {
            return null;  // 결과가 없을 때 명확하게 null 반환
        } else {
            return results.remove(0);  // 첫 번째 결과 삭제 후 반환
        }
    }
}

