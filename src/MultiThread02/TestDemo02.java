package MultiThread02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDemo02 {
    public static void main(String[] args) throws Exception {
        /*DiyThread2 diyThread1 = new DiyThread2();
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
        thread3.start();*/
//        如果不用任务体创建线程就不会共享，那时候线程就不是服务于同一个任务体了

        /**
         * 通过Callable接口实现多线程
         */
        //Callable类型的实例，任务体
        Callable01 callable = new Callable01();
        System.out.println(callable.call());
        //需要将Callable类型转化为Runable类型的类；FutureTask是Runable类型的一个子类
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //Thread 类型只能实现接口为Runable类型的任务体
        Thread thread = new Thread(futureTask);
        thread.start();
//        thread.start();//不能重复调用
        System.out.println("-----------------------------------");

        //Callable可以在主线程中获取到子线程的运行结果的
        try{
            //get方法是获取子线程的运行结果
            String s =futureTask.get();
            System.out.println(Thread.currentThread().getName()+" S: "+s);
        }catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        //匿名内部类创建线程
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"匿名内部类实现多线程");
            }
        };
        thread1.start();
    }
}
