package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Operator opAdd=new AddOperator();
        Operator opDivi=new DivideOperator();
        Operator opMul=new MultiplyOperator();
        Operator opSub=new SubtractOperator();
        Operator opMod=new ModOperator();
        Operator[] operators= {opAdd, opSub, opMul, opDivi};
        CircleCalculator cc=new CircleCalculator();
//        ArithmeticCalculator ac=new ArithmeticCalculator(operators);
        ArithmeticCalculator<Number> ac=new ArithmeticCalculator<>(operators);
       //Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        Scanner sc = new Scanner(System.in);
        Calculator calc=new Calculator();

        while (true) {
            // 프로그램 종료 입력은 메뉴 선택 이후에 처리함
            // 상단에 있으면 숫자 입력 흐름과 충돌나기 때문에
            // 메뉴 선택 후 EXIT처리 아래로 옮김

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
                        double result= ac.calculate(numOne,numTow,giho);
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
                       double area=cc.ArithmeticCalculator(radius);
                        System.out.println("원의 넓이를 계산했습니다.:"+area);
                    }catch (ArithmeticException e){
                        System.out.println("오류: "+e.getMessage());
                    }
                    // 모든 결과 조회는 통합된 listCal()하나로 처리하므로
                    // 개별 컬렉션 전용 호출 불필요함.
//                    System.out.print("저징된 원의 넓이 결과:");
//                    Calculator.listCircle();
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다!");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
                    return;
            }
            System.out.println("원하는 텍스트를 입력해 주세요.");
            System.out.println("remove/inquiry/inquiryGreater/exit/계속하실 거면 enter");
            String msg=sc.nextLine();
            //삭제
            if (msg.equals("remove")) {
                Double removed = calc.removeCal();
                if (removed == null) {
                    System.out.println("저장된 결과가 없음.");
                } else {
                    System.out.println("삭제된 결과: " + removed);
                }
            }
            else if(msg.equals("inquiry")){
                    ac.listCal();
                }else if(msg.equals("inquiryGreater")){
                    System.out.println("기준값을 입력해 주세요: ");
                    double threshold=sc.nextDouble();
//                    sc.nextLine();=> 이거 있어야 하는 이유를 모르겠음
                    ac.printResultsGreaterThan(threshold);
                }else if(msg.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                return;
            }

                System.out.println();
        }
    }
}
