package calculator;

import java.util.Queue;

public interface Calculator {
    //calculate 함수 추상화 가변인자
    double calculate(String... strings);
    //inquiryResults()에서 직접 저장 Queue에 접근을 해버리면 그만이라 getResultArr()가 쓰일일이 없는상태.
    Queue<Double> getResultArr();

    void setResultArr(double val);

    void removeResult();

    void inquiryResults();


}
