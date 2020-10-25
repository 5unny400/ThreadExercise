package MultiThread04;

public class OutLetterDemo extends Thread{
    MyObject object;
    volatile int num;
    volatile int index;
    String[] arr = {"A","B","C"};

    public void setNum(int num) {
        this.num = num;
    }

    OutLetterDemo(int index, MyObject object){
        this.index = index;
        this.object = object;
    }

    synchronized public int getNum(){
        return num;
    }

    @Override
    public void run() {
        while(num<10){
            synchronized(object){
                if(!(this.index==object.getIndex())){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    num++;
                    System.out.println(arr[this.index]);

                    object.setIndex((this.index+1)%3);
                    object.notifyAll();
                }
            }
        }
    }

    public static class MyObject{
        int index;

        public MyObject(int index) {
            this.index = index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }


    public static void main(String[] args) {
        MyObject myObject = new MyObject(0);

        new OutLetterDemo(0,myObject).start();
        new OutLetterDemo(1,myObject).start();
        new OutLetterDemo(2,myObject).start();
    }
}
