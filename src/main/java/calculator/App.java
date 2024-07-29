package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연산의 결과 10개를 담을 배열
        //문제 요구 조건이 애매해서 변수 최적화는 추후 단계에서 진행.

        //Calculator 변수 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        //변수 선언
        double firstNumber;
        double secondNumber;
        double radius;
        char operator;

        String calcCase;
        String run;
        String askRemove;
        String askPrint;

        //계산 실행 루프
        while (true) {
            System.out.println("계산기 프로그램 입니다.");
            //사칙연산 처리와 원의넓이 계산 처리를 분리
            System.out.println("사칙연산 처리는 \"사칙연산\" 을, 원의 넓이 계산은 \"원의넓이\" 를 입력해주세요.");
            calcCase = sc.next();
            if (calcCase.equals("사칙연산")) {
                //사칙연산 계산
                System.out.print("첫 번째 숫자를 입력해주세요 : ");
                firstNumber = sc.nextDouble();

                System.out.print("두 번째 숫자를 입력해주세요 : ");
                secondNumber = sc.nextDouble();

                System.out.println("+ - * / 각 연산에 맞는 연산자를 입력해주세요");
                operator = sc.next().charAt(0);

                //arithmeticCalculator 클래스의 인스턴스를 사용해 연산 진행 및 저장.
                arithmeticCalculator.setResultArr(arithmeticCalculator.calculate(operator,firstNumber,secondNumber));

                //저장한 resultArr 출력
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                askPrint = sc.next();
                if (askPrint.equals("inquiry")) {
                    //작성한 inquiry를 사용하여 연산 데이터를 가져와서 출력.
                    arithmeticCalculator.inquiryResults();
                }

                //remove를 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록.
                System.out.println("가장 먼저 저장된 연산 결과를  삭제하시겠습니까? (remove 입력 시 삭제)");
                askRemove = sc.next();
                if (askRemove.equals("remove")) {
                    arithmeticCalculator.removeResult();
                }

            } else if (calcCase.equals("원의넓이")) {
                //원의 넓이 계산
                System.out.print("반지름의 값을 입력해주세요 : ");
                radius = sc.nextDouble();

                //circleCalculator 클래스의 인스턴스를 사용해 연산 진행 및 저장.
                circleCalculator.setResultArr(circleCalculator.calculateCircleArea(radius));

                //저장한 circleResultArr 출력
                System.out.println("저장된 원의넓이결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                askPrint = sc.next();
                if (askPrint.equals("inquiry")) {
                    circleCalculator.inquiryResults();
                }

            } else {
                //잘못된 계산 방식 입력 처리.
                System.out.println("올바르지 않은 계산방식 입력입니다.");
                continue;
            }


            //무한 반복 while 루프문 탈출 조건 설정.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, 아무키나 입력시 진행)");
            run = sc.next();
            if (run.equals("exit")) {
                System.out.println("계산기 실행을 종료합니다.");
                break;
            }

        }

        System.out.println();
        //스캐느 객체 닫기는 습관화.
        sc.close();
    }
}