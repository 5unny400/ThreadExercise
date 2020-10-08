package exercise01;

/**
 * @Author Shenxinyuan
 * @Description //TODO
 * @Date 19:53 2020/10/8 0008
 * @Param
 * @return
 **/
public class exercise01 {
    public static void main(String[] args) {

        Thread thread01 = new MyThread("A");
        Thread thread02 = new MyThread("B");
        Thread thread03 = new MyThread("C");
        try {
            thread01.start();
            thread01.join();

            thread02.start();
            thread02.join();

            thread03.join();
            thread03.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class MyThread extends Thread {
    String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.print(name);
    }
}
