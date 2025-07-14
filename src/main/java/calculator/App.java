package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
//Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in);
        Calculator calc=new Calculator();
        //무한 저장
//        List<Integer> results =new ArrayList<>();

        while (true) {
            System.out.println("첫 번째 숫자를 입력해 주세요.");
            int numOne = sc.nextInt();
            sc.nextLine();

            System.out.println("두 번째 숫자를 입력해 주세요.");
            int numTow = sc.nextInt();
            sc.nextLine();

            //Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.println("사칙 연산 기호를 입력하세요.");
            char giho=sc.nextLine().charAt(0);
            boolean error = false;

            try {
                double result= calc.calculate(numOne,numTow,giho);
                System.out.println("결과"+result);
            }catch (ArithmeticException e){
                System.out.println("오류: "+e.getMessage());
            }
            //입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.


            System.out.println("더 계산을 하시겠습니까? (exit 입력 시 종료됩니다.)");
            String msg = sc.nextLine();

            //종료
            if (msg.equals("exit")) {
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                break;
            }

            //삭제
            if (msg.equals("remove")) {
                Double removed = calc.removeTodo();
                if (removed == null) {
                    System.out.println("저장된 결과가 없음.");
                } else {
                    System.out.println("삭제된 결과: " + removed);
                }
                System.out.println();
                continue;
            }

            //조회
            if(msg.equals("inquiry")){
                List<Double> stored=calc.getResults();
                if(stored.isEmpty()){
                    System.out.println("저장된 결과가 없음");
                }else {
                    System.out.println("저장된 연산 결과:");
                    for(double r:stored){
                        System.out.println(r);
                    }
                }
                System.out.println();
                continue;
            }


            System.out.println();
        }
        sc.close();
    }
}
