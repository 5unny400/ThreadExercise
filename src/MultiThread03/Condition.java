package MultiThread03;

public class Condition implements Runnable {



    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            //执行同步方法
            test1();
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            //执行非同步方法
            test2();
        }
    }



    //同步方法
    public synchronized void test1() {
        System.out.println("线程名："+Thread.currentThread().getName()+" 线程开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名："+Thread.currentThread().getName()+" 线程结束");

    }

    //非同步方法
    public void  test2() {
        System.out.println("线程名："+Thread.currentThread().getName()+" 线程开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名："+Thread.currentThread().getName()+" 线程结束");

    }

    public static void main(String[] args) {
        Condition condition = new Condition();
        Thread t1 = new Thread(condition);
        Thread t2 = new Thread(condition);
        t1.start();
        t2.start();


    }
}