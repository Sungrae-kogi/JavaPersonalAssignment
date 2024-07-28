package calculator;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연산의 결과 10개를 담을 배열
        //Queue<Integer> resultArr = new LinkedList<>();

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