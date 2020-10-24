package MultiThread03;

public class SynchronizedDemo {
    public static void main(String[] args) {
        //静态方法的调用
        //锁的是class实例，即所有对象，不能并发执行，只能是串行执行
        SynchronizedDemo.test3();


        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();


        /**
         * 加入两个线程，同时拥有该对象实例，一个线程调用test2，一个线程调用test4；两个方法可以同时执行么??
         *
         * 显然不能
         * test2和test4都是Synchronized修饰的普通方法
         * Synchronized加载普通方法上，锁的是普通方法
         * 一个对象实例一个线程获取，首先占有当前对象实例，然后调用该对象的方法，两个线程同时执行谁先获取到对象实例，谁先运行，
         * 另一个线程只能等待当前获取对象实例的线程释放对象之后，才能继续执行。
         */
        SubSynchronizedDemo2 demo2 = new SubSynchronizedDemo2(synchronizedDemo);
        demo2.start();
        SubSynchronizedDemo4 demo4 = new SubSynchronizedDemo4(synchronizedDemo);
        demo4.start();



        /**
         *两个线程，分别来获取不同对象实例的test2方法，两个线程可以并发执行么？？
         * 当然可以
         */
        SubSynchronizedDemo2 synchronizedDemo2 = new SubSynchronizedDemo2(synchronizedDemo);
        synchronizedDemo2.start();
        SubSynchronizedDemo2 synchronizedDemo4 = new SubSynchronizedDemo2(synchronizedDemo1);
        synchronizedDemo4.start();
    }



    //修饰代码块
    public void test1(Object o){
        synchronized(o){
            //a++  //可以保证原子性
        }
    }

    //修饰普通方法
    public synchronized void test2(){

    }
    public synchronized void test4(){

    }

    //修饰静态方法
    public synchronized static void test3(){
        System.out.println("test3()执行。。。");
    }
}
