package calculator;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연산의 결과 10개를 담을 배열
        Queue<Integer> resultArr = new LinkedList<>();

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

            try {
                switch (operator) {
                    case '+':
                        result = firstNumber + secondNumber;
                        System.out.println("두 수의 더하기의 결과는 : " + result);
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        System.out.println("두 수의 뺄셈의 결과는 : " + result);
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        System.out.println("두 수의 곱의 결과는 : " + result);
                        break;
                    case '/':
                        if (secondNumber == 0) {
                            throw new ArithmeticException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        }
                        result = firstNumber / secondNumber;
                        System.out.println("두 수의 나눗셈 결과는 : " + result);
                        break;
                    default:
                        System.out.println("잘못된 연산자의 입력입니다.");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

            //Queue에 추가.
            resultArr.add(result);
            System.out.println();

            //remove를 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록.
            System.out.println("가장 먼저 저장된 연산 결과를  삭제하시겠습니까? (remove 입력 시 삭제)");
            askRemove = sc.next();
            if(askRemove.equals("remove")) {
                resultArr.poll();
            }

            //저장한 resultArr 출력
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            askPrint = sc.next();
            if(askPrint.equals("inquiry")) {
                for(Integer res : resultArr){
                    System.out.print(res+" ");
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