package calculator;

public class DivideOperator{
    public int operate(double firstNumber, double secondNumber) throws ArithmeticException {
        double result;
        if(secondNumber == 0){
            throw new ArithmeticException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        }
        result = firstNumber / secondNumber;

        return (int) result;
    }
}
