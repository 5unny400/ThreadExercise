package MultiThread04;

public class NotifyDemo extends Thread {
    private Object o;
    private String name;
    public NotifyDemo(Object o,String name) {
        this.o = o;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (o) {
            System.out.println(name+"线程已获取O对象锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.notify();
            System.out.println(name+"线程释放O对象锁");
        }
    }
}