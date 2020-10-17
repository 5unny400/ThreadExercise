package exercise01;

public class ThreadDemo2Test {
    public static void main(String[] args) {
        Thread a = new ThreadDemo2(null,"A");
        Thread b = new ThreadDemo2(a,"B");
        Thread c = new ThreadDemo2(b,"C");

        a.start();
        b.start();
        c.start();
    }
}
