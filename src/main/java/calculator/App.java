package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber;
        int secondNumber;
        char operator;
        int result;

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
            System.out.println();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, 아무키나 입력시 진행)");
            String run = sc.next();
            if (run.equals("exit")) {
                System.out.println("계산기 실행을 종료합니다.");
                break;
            }

        }

    }
}