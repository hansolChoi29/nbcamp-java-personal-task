package calculator;

import java.util.ArrayList;
import java.util.List;

//결과 값을 반환하는 메서드와
//연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스
public class Calculator {

    // (1) 인라인 초기화
    // private final List<Double> results = new ArrayList<>(); 생성자가 있으니 아래와 같이 수정함
    // (2) 생성자 초기화 — 위 인라인 초기화와 같은 기능
    private  final  List<Double> results;
    //생성자에서 results로 초기화
    public Calculator(){
        this.results= new ArrayList<>();
    }

    //결과 저장 메서드: 연산 결과 result에 추가함.
    // 이유=> addResult를 통해 어떤 계산이든 공통 로직을 한곳에 모아두면
    // 중복x, 파일기록이나 저장 등 오직 이 메서드만 수정하면 됨.
    public void addResult(double result){
        results.add(result);
    }
    //원의 넓이 결과 저장하는 필드
    //2-7 static사용한 이유🔥: 모든 인스턴스가 공유해야 함(인라인)
//    private static final List<Double> circle=new ArrayList<>();
    public Double removeCal(){
        if(results.isEmpty()){
            return null;
        }else{
            return results.remove(0);
        }
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



    //조회 : 반환값이 없으므로 출력책임을 가짐.
    public  void listCal(){
            if(results.isEmpty()){
                System.out.println("저장된 결과가 없음");
            }else {
                System.out.println("저장된 연산 결과:");
                for(double r:results){
                    System.out.println(r);
                }
            }
    }

}

