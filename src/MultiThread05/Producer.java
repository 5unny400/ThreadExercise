package MultiThread05;

class Producer extends Thread{
    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(wareHouse) {
                if (wareHouse.getNumOfThing() < wareHouse.MAXSIZE) {
                    System.out.println("生产前仓库现余货数量："+wareHouse.getNumOfThing());
                    System.out.println("生产者生产数量：" + wareHouse.produce());
                    System.out.println("生产后仓库现余货数量："+wareHouse.getNumOfThing());
                    System.out.println("++++++++++++++++++++++++++++++");
                    wareHouse.notifyAll();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
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
