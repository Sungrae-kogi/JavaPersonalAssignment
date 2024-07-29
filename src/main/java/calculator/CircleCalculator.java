package calculator;

import java.util.Queue;
import java.util.LinkedList;

public class CircleCalculator implements Calculator {
    public static final double PI_VALUE = Math.PI;
    private Queue<Double> resultArr;

    //생성자
    public CircleCalculator() {
        this.resultArr = new LinkedList<>();
    }

    //추상메소드 구현
    @Override
    public double calculate(String... strings) {
        double result = Double.NaN;
        try{
            result = PI_VALUE * Double.parseDouble(strings[0]) * Double.parseDouble(strings[0]);
            System.out.println("계산된 원의 넓이 : " + result);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }

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
