package calculator;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator{
    //원과 관련된 연산을 수행하는 계산기
    // 원의 넓이를 계산 후 부모의 addResult로 저장
    //private static final List<Double> circle=new ArrayList<>();
    //=>listCircle없앰.
    public double ArithmeticCalculator (double radius){
        if(radius<0){
            throw new ArithmeticException("반지름은 음수일 수 없습니다.");
        }
        double area=Math.PI*Math.pow(radius,2);
        addResult(area);
        return area;
    }
    //private static final List<Double> circle 제거 이유:
    // 결과저장을 모두 부모클래스 Calculator의 results로 통합했기 때문

    public static List<Double> getCircle(){
        return new ArrayList<>();
    }
    //원의 넓이 조회
    //getCircle()와 listCircle() 삭제 이유:
    // 위에서 circle리스트를 없앴으므로 필요없음
    //    public static void listCircle(){
    //        if(circle.isEmpty()){
    //            System.out.println("저장된 원의 넓이가 없음");
    //        }else{
    //            System.out.println("저장된 원의 넓이: ");
    //            for(double area:circle){
    //                System.out.println(area);
    //            }
    //        }
    //    }
}
