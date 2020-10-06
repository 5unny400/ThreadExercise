package MultiThread02;


public class TestDemo {
    public static void main(String[] args) {

       /* //快捷键
        System.out.println(1 + 2);      //1+2.sout
        ArrayList a = new ArrayList<>();        //new ArrayList.var
        for (Object o : a) {
            //a.for
        }*/

        DiyThread diyThread = new DiyThread();//直接实例化Thread类
        diyThread.start();
        System.out.println(Thread.currentThread().getName()+"<继承Thread类>");
    }
}
