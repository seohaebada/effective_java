package me.whiteship.chapter05.item32.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * ThreadLocal
 * - 모든 멤버 변수는 기본적으로 여러 쓰레드에서 공유해서 쓰일 수 있다.
 * 쓰레드 안전성과 관련된 여러 문제가 발생할 수 있다.
 * - 쓰레드 지역 변수를 사용하면 동기화하지 않아도 한 쓰레드에서만 접근가능한 값이기 때문에 안전하게 사용 가능하다.
 * - 한 쓰레드 내에서 공유하는 데이터로, 메서드 매개변수에 매번 전달하지 않고 전역 변수처럼 사용할 수 있다.
 */
public class ThreadLocalExample implements Runnable {

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

//    private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmm");

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat()); // 기본패턴으로 변경

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }

}

