package calculator;

import java.util.Queue;
import java.util.LinkedList;

public abstract class Calculator {
    //calculate 함수도 추상화 하려 했으나, 구조를 아예 뜯어고쳐야 해서 보류.

    //inquiryResults()에서 직접 저장 Queue에 접근을 해버리면 그만이라 getResultArr()가 쓰일일이 없는상태.
    public abstract Queue<Double> getResultArr();

    public abstract void setResultArr(double val);

    public abstract void removeResult();

    public abstract void inquiryResults();


}
