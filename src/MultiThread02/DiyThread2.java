package MultiThread02;

class DiyThread2 extends Thread{
    private int count = 4;      //如果使用static就共享了
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "count:" + --count + " ");
    }
}
