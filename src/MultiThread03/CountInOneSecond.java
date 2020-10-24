package MultiThread03;

public class CountInOneSecond {

    //volatile用了Synchronized就不用了volatile
    private static  boolean flag = true; //线程共享变量

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (isChanged()) {
                    count++;
                }
                System.out.println("count:" + count);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setFlag(false);
                System.out.println("一秒钟结束后：");
            }
        });
        t1.start();
        t2.start();
    }

    //判断flag是否修改
    public synchronized static boolean isChanged(){
        return flag;
    }

    //修改flag
    public synchronized static void setFlag(boolean b){
        flag = b;
    }

}
