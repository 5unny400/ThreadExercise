package MultiThread01;

import org.junit.Test;

class ImplRunable implements Runnable {

    @Test
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"实现我的Runable的run方法");
    }
}
