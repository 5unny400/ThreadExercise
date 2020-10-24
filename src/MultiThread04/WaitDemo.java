package MultiThread04;

public class WaitDemo extends Thread {
    private String name;
    private Object o;

    public WaitDemo(String name, Object o){
        this.name = name;
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            System.out.println(name + "线程获取o对象锁");
            try {
                /**
                 * 在当前synchronied修饰之中，则必须具有原子性
                 * 即当前大括号中的代码不可分割
                 * wait方法之后释放了锁，wait之后的代码和wait事件的代码还是否具有原子性？？
                 */
                //当前线程阻塞
                o.wait();
                //wait方法调用后，会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "线程释放o对象锁");
        }
    }
}
