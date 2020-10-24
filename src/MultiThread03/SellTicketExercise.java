package MultiThread03;

public class SellTicketExercise {
    private static int NUM = 100;
    private static volatile int num[] = new int[NUM];
    private static volatile int isSold;
    private volatile boolean isSoldOver = false;

    public SellTicketExercise(int num) {
        NUM = num;
    }

    public synchronized void getTicket() {
        int x = (int) (Math.random() * 100);
        if (num[x] == 0) {
            num[x] = 1;
            isSold++;
            System.out.println(Thread.currentThread().getName() + "购买票号：" + x);
        } else if (isSold == NUM) {
            isSoldOver = true;
            System.out.println(Thread.currentThread().getName() + "所有车票已售完！");
        } else {
            System.out.println(Thread.currentThread().getName() + "票号：" + x + "已被购买！");
        }
    }

    public synchronized boolean getIsSoldOver() {
        return isSoldOver;
    }

    static class MyThread implements Runnable {
        SellTicketExercise sellTicketExercise;

        MyThread(SellTicketExercise sellTicketExercise) {
            this.sellTicketExercise = sellTicketExercise;
        }

        @Override
        public void run() {
            sellTicketExercise.getTicket();
        }
    }

    public synchronized void check() {
        boolean label = false;
        for (int i = 0; i < NUM; i++) {
            if (num[i] == 0) {
                label = true;
                System.out.println(num[i] + " ");
            }
        }
        if (!label) {
            System.out.println("确认所有车票均已卖完！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        SellTicketExercise sellTicketExercise = new SellTicketExercise(num);

        MyThread myThread1 = new MyThread(sellTicketExercise);
        MyThread myThread2 = new MyThread(sellTicketExercise);
        MyThread myThread3 = new MyThread(sellTicketExercise);

        while (true) {
            boolean label = sellTicketExercise.getIsSoldOver();
            if (!label) {
                new Thread(myThread1).start();
                new Thread(myThread2).start();
                new Thread(myThread3).start();
                System.out.println("---------------------");
                Thread.sleep(100);
            } else {
                break;
            }
        }

        System.out.println("=====================");
        sellTicketExercise.check();
    }

}
