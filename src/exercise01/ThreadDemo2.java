package exercise01;

class ThreadDemo2 extends Thread {

    private Thread thread;  //线程实例
    private String name;        //线程名

    public ThreadDemo2(Thread thread,String name){
        this.name = name;
        this.thread = thread;
    }

    @Override
    public void run() {
        if(thread != null){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+"线程执行");
    }
}


