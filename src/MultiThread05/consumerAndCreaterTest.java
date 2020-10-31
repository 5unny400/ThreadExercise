package MultiThread05;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class consumerAndCreaterTest {

    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse(3,5);

        long t1 = System.currentTimeMillis();

        Consumer consumer = new Consumer(wareHouse);
        Producer producer = new Producer(wareHouse);
        consumer.start();
        producer.start();

        //运行4秒
        while(true) {
            if(System.currentTimeMillis()-t1>9000) {
                System.exit(0);
            }
        }


//        ConcurrentHashMap concurrentHashMap;    //线程安全 数据结构
//        HashMap hashMap;
//        Hashtable hashtable;
    }
}
