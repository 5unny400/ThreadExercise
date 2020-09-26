package MultiThread02;

class DiyRunable implements Runnable {
    private int countt = 4;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "countt:" + --countt + " ");
    }
}
