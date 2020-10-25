package MultiThread04;

public class OutNumberInOrderStandard extends Thread{
    MyObject object;
    static volatile int num;
    volatile int index;
    String[] arr = {"A","B","C"};

    public void setNum(int num) {
        this.num = num;
    }

    OutNumberInOrderStandard(int index, MyObject object){
        this.index = index;
        this.object = object;
    }

    synchronized public int getNum(){
        return num;
    }

    @Override
    public void run() {
        while(getNum()<103){
            synchronized(object){
                if(!(this.index==object.getIndex())){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.print(arr[this.index]+":");

                    int i =0;
                    while(i<=5&&upNum()){
                        System.out.print(this.num+" ");
                        i++;
                    }
                    System.out.println();

                    object.setIndex((this.index+1)%3);
                    object.notifyAll();
                }
            }
        }
    }

    synchronized private boolean upNum() {
        num++;
        return num<103;
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

        new OutNumberInOrderStandard(0,myObject).start();
        new OutNumberInOrderStandard(1,myObject).start();
        new OutNumberInOrderStandard(2,myObject).start();
    }
}
