package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연산의 결과 10개를 담을 배열
        int[] resultArr = new int[10];
        int idx = 0;
        
        //변수 선언
        int firstNumber;
        int secondNumber;
        char operator;
        String run;
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
            //계산결과 저장 idx > 9 일때 가장 예전에 저장한 것(idx=0)을 지우고 새로운 값을 가장 마지막자리(idx=9)에 저장.
            if(idx > 9){
                //0 idx는 버리는 수, i = 1~9까지를 i-1로 하나씩 옮겨주고 루프가 끝난뒤 i=9 자리에 새로운 값을 할당.
                for(int i=1; i<=9; i++){
                    resultArr[i-1] = resultArr[i];
                }
                //마지막 자리 = 새로온 값 할당.
                resultArr[9] = result;
            }else{
                resultArr[idx++] = result;
            }

            System.out.println();


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, 아무키나 입력시 진행)");
            run = sc.next();
            if (run.equals("exit")) {
                System.out.println("계산기 실행을 종료합니다.");
                break;
            }

        }

        //저장한 resultArr 출력
        System.out.println("가장 최근의 계산 결과 10개를 출력합니다.");
        for(int res : resultArr){
            System.out.print(res+" ");
        }
        System.out.println();
    }
}