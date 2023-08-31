package me.whiteship.chapter05.item32.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {

    public static void main(String[] args) {
        /*
            java.util.Random은 멀티스레드 환경에서 CAS(CompareAndSet)로 인해 실패할 가능성이 있어서 성능이 좋지않다.
            next()에서 그럼 계속 반복하게되서 성능이 안좋아짐
         */
        Random random = new Random();
        System.out.println(random.nextInt(10));

        /*
            안전
            현재 쓰레드의 ThreadLocalRandom을 가져온다.
         */
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt(10));
    }

    private int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue)
    {
        // 원래 가지고있던 값을 너가 가지고있다면 원하는 값으로 수정하겠다. 라는 뜻이다.
        int readValue = value;
        if (readValue == expectedValue)
            value = newValue;
        return readValue;
    }
}
