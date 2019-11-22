package Latch;

import java.util.concurrent.CountDownLatch;

public class Player implements Runnable {
    private CountDownLatch begin;
    private CountDownLatch end;

    Player(CountDownLatch begin, CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }
    @Override
    public void run() {//每一个线程在这里开始运行
        try {
            System.out.println(Thread.currentThread().getName()  + " begins now!");
            begin.await();
            System.out.println(Thread.currentThread().getName() + "end.");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
