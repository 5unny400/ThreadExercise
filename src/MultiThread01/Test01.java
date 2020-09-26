package MultiThread01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test01 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
//        Process process = runtime.exec("ls");
        //将ls的执行结果通过io形式获取
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

//        String readLine = reader.readLine();
//        System.out.println(readLine);
        testImlRunable();
    }

    /**
     * 线程创建方式介绍
     */
    public static void testImlRunable(){

        ImplRunable implRunable = new ImplRunable();    //任务体实例化
        //创建线程实例
        Thread myTread = new Thread(implRunable);   //通过任务体实例化Thread类
        myTread.start();
        System.out.println(Thread.currentThread().getName()+"<>实现Runable接口");

    }

}
