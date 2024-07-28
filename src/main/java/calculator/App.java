package calculator;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연산의 결과 10개를 담을 배열
        //문제 요구 조건이 애매해서 변수 최적화는 추후 단계에서 진행.
        Queue<Integer> resultArr;

        //Calculator 변수 생성
        Calculator calculator = new Calculator();

        //변수 선언
        int firstNumber;
        int secondNumber;
        char operator;
        String run;
        String askRemove;
        String askPrint;
        int result = 0;

        //계산 실행 루프
        while (true) {
            System.out.println("계산기 프로그램 입니다.");
            System.out.print("첫 번째 숫자를 입력해주세요 : ");
            firstNumber = sc.nextInt();

            System.out.print("두 번째 숫자를 입력해주세요 : ");
            secondNumber = sc.nextInt();

            System.out.println("+ - * / 각 연산에 맞는 연산자를 입력해주세요");
            operator = sc.next().charAt(0);

            calculator.calculate(operator, firstNumber, secondNumber);


            //저장한 resultArr 출력
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            askPrint = sc.next();
            if(askPrint.equals("inquiry")) {
                //작성한 Getter를 사용하여 연산 데이터를 가져와서 출력.
                resultArr = calculator.getResultArr();
                System.out.print("저장된 연산 결과 : ");
                for(Integer res : resultArr){
                    System.out.print(res + " ");
                }
                System.out.println();
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
    }
}