package MultiThread02;

import java.util.concurrent.Callable;

/**
 * 通过实现Callable实现多线程
 */
public class Callable01 implements Callable {       //
    @Override
    public Object call() throws Exception {     //在callable接口里是V泛型返回值
        System.out.println(Thread.currentThread().getName()+"<>");
        return null;
    }
}
