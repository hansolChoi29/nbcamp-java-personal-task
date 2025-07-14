package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
       //Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in);
        Calculator calc=new Calculator();

        while (true) {
            System.out.println("더 계산을 하시겠습니까? (exit 입력 시 종료됩니다.)");
            String msg = sc.nextLine();
            if(msg.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //분기점 만들기 및 다 갈아엎기
            System.out.println("1.사칙 연산하기  2.원의 넓이 구하기 3.종료 (번호를 입력해 주세요.)");
            System.out.print("선택: ");
            int choice=sc.nextInt();

            // switch(choice) case 1, 2, 3에 따른 분기점
            switch (choice){
                case 1:
                    System.out.println("사칙연산 하기 시작!");
                    System.out.println("첫 번째 숫자를 입력해 주세요.");
                    int numOne = sc.nextInt();
                    sc.nextLine();

                    System.out.println("두 번째 숫자를 입력해 주세요.");
                    int numTow = sc.nextInt();
                    sc.nextLine();

                    //Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
                    System.out.println("사칙 연산 기호를 입력하세요.");
                    char giho=sc.nextLine().charAt(0);

                    try {
                        double result= calc.calculate(numOne,numTow,giho);
                        System.out.println("결과"+result);
                    }catch (ArithmeticException e){
                        System.out.println("오류: "+e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("원의 넓이를 계산합니다.");
                    System.out.println("원의 반지름을 입력해 주세요!");
                    double radius=sc.nextDouble();
                    sc.nextLine();

                    try{
                        Calculator.calculatorCirecle(radius);
                        System.out.println("원의 넓이를 계산했습니다.");
                    }catch (ArithmeticException e){
                        System.out.println("오류: "+e.getMessage());
                    }

                    System.out.print("저징된 원의 넓이 결과:");
                    Calculator.listCircle();
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다!");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
                    return;
            }

            //삭제
            if (msg.equals("remove")) {
                Double removed = calc.removeCal();
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
               calc.listCal();
                System.out.println();
                continue;
            }
            System.out.println();
        }
        sc.close();
    }
}
