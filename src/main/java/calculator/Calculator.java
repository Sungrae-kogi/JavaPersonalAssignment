package calculator;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    //연산 결과를 저장할 컬렉션
    private Queue<Integer> resultArr = new LinkedList<>();

    //스캐너 객체
    Scanner sc = new Scanner(System.in);

    public int calculate(char operator, int firstNumber, int secondNumber) {
        int result = 0;
        String askRemove;
        String askPrint;

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

        //Queue에 추가 - 추가한 setter 메소드 사용.
        setResultArr(result);


        //remove를 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록.
        System.out.println("가장 먼저 저장된 연산 결과를  삭제하시겠습니까? (remove 입력 시 삭제)");
        askRemove = sc.next();
        if (askRemove.equals("remove")) {
            resultArr.poll();
        }


        return result;
    }

    //Getter -> 저장된 연산결과 가져오기.
    public Queue<Integer> getResultArr() {
        return resultArr;
    }

    //Setter -> 간접 접근으로 필드에 접근하여 수정 리턴은 필요없으니 void
    //요구사항이 자세하지않아 요소 추가 기능을 구현합니다.
    public void setResultArr(int val) {
        resultArr.add(val);
        System.out.println("입력한 값이 큐에 저장되었습니다.");
        System.out.println();
    }
}
