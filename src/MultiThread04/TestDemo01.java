package MultiThread04;

public class TestDemo01 {
    public static void main(String[] args) {
        Object o = new Object();


        WaitDemo waitDemo = new WaitDemo("wait",o);
        NotifyDemo notifyDemo = new NotifyDemo(o,"notify");


        notifyDemo.start();
        waitDemo.start();
    }
}
