package calculator;

import java.util.Queue;
import java.util.LinkedList;

public class Calculator {
    //연산 결과를 저장할 컬렉션
    private Queue<Integer> resultArr = new LinkedList<>();

    public int calculate(char operator, int firstNumber, int secondNumber) {
        int result = 0;

        //try catch로 오류 발생시 예외처리 적합한 Exception클래스생성 및 매개변수 전달.
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
                    throw new IllegalArgumentException("잘못된 연산자 기호의 입력입니다.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return result;
    }
}
