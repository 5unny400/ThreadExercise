package MultiThread03;

public class SubSynchronizedDemo4 extends Thread{
    SynchronizedDemo synchronizedDemo;
    public SubSynchronizedDemo4(SynchronizedDemo synchronizedDemo) {
        this.synchronizedDemo = synchronizedDemo;
    }

    @Override
    public void run(){
        // SynchronizedDemo.test3();
//        synchronizedDemo.test2();
        System.out.println("4");
    }
}
