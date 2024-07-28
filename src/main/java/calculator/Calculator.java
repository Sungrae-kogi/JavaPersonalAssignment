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

        //Queue에 추가 - 추가한 setter 메소드 사용.
        setResultArr(result);

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

    //resultArr 에 저장된 데이터 중 가장 먼저 저장된 데이터를 삭제.
    public void removeResult(){
        // 큐가 비어있지 않다면 삭제,
        if(!resultArr.isEmpty()){
            resultArr.poll();
            System.out.println("가장 먼저 저장된 데이터가 하나 삭제되었습니다.");
        }else{
            System.out.println("현재 큐에 저장된 데이터가 없어 삭제가 되지않았습니.");
        }
    }
}
