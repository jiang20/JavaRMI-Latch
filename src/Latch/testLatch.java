package Latch;

import java.util.concurrent.CountDownLatch;

public class testLatch {//用来测试latch

    //CountDownLatch是一个同步类工具，当count值为0时当前线程可继续运行；不涉及同步，当线程间通信时，使用这个很合适

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for(int i=0; i<2; i++){
            Thread thread = new Thread(new Player(begin,end),String.valueOf(i));//创建子线程
            thread.start();
        }
        try{
            System.out.println("the race begin");
            begin.countDown();
            end.await();//await() 方法具有阻塞作用，也就是说主线程在这里暂停
            System.out.println("the race end");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
