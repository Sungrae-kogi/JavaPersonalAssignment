package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator extends Calculator {
    private Queue<Double> resultArr;

    //생성자
    public ArithmeticCalculator() {
        this.resultArr = new LinkedList<Double>();
    }

    //사칙연산 처리 - 연산자와 두 개의 수 입력
    public double calculate(char operator, double firstNumber, double secondNumber) {
        double result = 0;

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

    //추상메소드 구현
    @Override
    public Queue<Double> getResultArr() {
        return resultArr;
    }

    @Override
    public void setResultArr(double val) {
        resultArr.add(val);
        System.out.println("입력한 값이 큐에 저장되었습니다.");
        System.out.println();
    }

    @Override
    public void removeResult() {
        //큐가 비어있지 않다면 삭제
        if (!resultArr.isEmpty()) {
            resultArr.poll();
            System.out.println("가장 먼저 저장된 데이터가 하나 삭제되었습니다.");
        } else {
            System.out.println("현재 큐에 저장된 데이터가 없어 삭제가 되지않았습니.");
        }
    }

    @Override
    public void inquiryResults() {
        System.out.print("저장된 연산 결과 : ");
        for (Double res : resultArr) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
