package MultiThread02;

import java.util.concurrent.Callable;

public class TestDemo02 {
    public static void main(String[] args) {
        DiyThread2 diyThread1 = new DiyThread2();
        DiyThread2 diyThread2 = new DiyThread2();
        DiyThread2 diyThread3 = new DiyThread2();
        diyThread1.start();
        diyThread2.start();
        diyThread3.start();

        System.out.println();

        //共享
        DiyRunable diyRunable = new DiyRunable();//通过任务体DIYRunable创建线程是共享的关键
        Thread thread1 = new Thread(diyRunable);
        Thread thread2 = new Thread(diyRunable);
        Thread thread3 = new Thread(diyRunable);
        thread1.start();
        thread2.start();
        thread3.start();
//        如果不用任务体创建线程就不会共享，那时候线程就不是服务于同一个任务体了



    }
}
