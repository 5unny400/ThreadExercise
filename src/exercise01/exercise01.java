package exercise01;

public class exercise01 {
    public static void main(String[] args) {

        Runnable runable = new MyRunable();

        try {
//            Thread.sleep(3000);//主线程睡眠，后边的线程也不能继续
            System.out.println(Thread.currentThread().getName()+" 主线程开始");

            Thread thread01 = new Thread(runable, "A");
            Thread thread02 = new Thread(runable, "B");
            Thread thread03 = new Thread(runable, "C");

            thread01.join(3000);
            thread01.start();
            thread02.join(2000);
            thread02.start();
            thread03.join(1000);
            thread03.start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            System.out.println(Thread.currentThread().getName()+" 主线程结束");
        }

    }
}

class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  Runable接口实现的线程");
    }
}
