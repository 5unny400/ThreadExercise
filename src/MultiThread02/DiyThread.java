package MultiThread02;

/**
 * 继承Thread类创建多线程
 */
class DiyThread extends Thread{
        //重写run方法

    @Override
    public void run() {
        //子线程的业务都在run方法中
        System.out.println(Thread.currentThread().getName()+"<通过继承Thread类创监多线程>");
    }
}
