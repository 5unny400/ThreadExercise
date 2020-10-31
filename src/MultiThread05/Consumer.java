package MultiThread05;

public class Consumer extends Thread{
    private WareHouse wareHouse;

    public Consumer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(wareHouse) {
                if (wareHouse.getNumOfThing() > 0) {
                    System.out.println("消费前仓库现余货数量："+wareHouse.getNumOfThing());
                    System.out.println("消费者消费数量：" + wareHouse.consume());
                    System.out.println("消费后仓库现余货数量："+wareHouse.getNumOfThing());
                    System.out.println("----------------------------------");
                    wareHouse.notifyAll();      //生产者消费者线程都会接到通知，因为是同一个wareHouse对象
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{      //否则消费者线程阻塞
                    try {
                        wareHouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
