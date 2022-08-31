package exercise01;


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

            thread03.start();
//            thread03.join();//这行可有可无
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
