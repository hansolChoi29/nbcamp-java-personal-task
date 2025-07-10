package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
//Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in);

        //무한 저장
        Scanner scanner =new Scanner(System.in);
        List<Double> results =new ArrayList<>();

        while (true) {
            System.out.println("첫 번째 숫자를 입력해 주세요.");
            int numOne = scanner.nextInt();
            System.out.println("두 번째 숫자를 입력해 주세요.");
            int numTow = scanner.nextInt();

            if (numOne < 0 || numTow < 0) {
                System.out.println("양의 정수(0 포함)만 입력 가능합니다.");
                continue;
            }

            //Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.println("사칙 연산 기호를 입력하세요.");
            char giho = sc.nextLine().charAt(0);
            double result = 0;
            boolean error = false;

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
                        System.out.println("나눗셈 연산에서 부모에 0이 입력될 수 없습니다.");
                        error = true;
                    } else {
                        result = (double) numOne / numTow;
                    }
                    break;
                default:
                    System.out.println("지원하지 않는 연산 기호입니다.");
                    error = true;
            }
            //입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력합니다.
            if (!error) {
                System.out.println("결과" + result);
                results.add(result);
            }


            // error: nextInt을 호출했는데 exit문자열이 들어오면서 파싱되어 실패.
            System.out.println("더 계산을 하시겠습니까? (exit 입력 시 종료됩니다.)");
            String msg = sc.nextLine();

            //종료
            if (msg.equals("exit")) {
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                break;
            }

            //삭제
            if(msg.equals("remove")){
                if(results.isEmpty()){
                    System.out.println("저장된 결과가 없음.");
                }else{
                    double removed =results.remove(0);
                    System.out.println("삭제된 결과 : "+removed);
                }
                System.out.println();
                continue;
            }

            //조회
            if(msg.equals("inquiry")){
                if(results.isEmpty()){
                    System.out.println("저장된 결과가 없음");
                }else {
                    System.out.println("저장된 연산 결과:");
                    for(double r:results){
                        System.out.println(r);
                    }
                }
                System.out.println();
                continue;
            }


            System.out.println();
            //반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
        }
        sc.close();
        scanner.close();
    }
}
