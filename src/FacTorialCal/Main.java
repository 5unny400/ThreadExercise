package FacTorialCal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 本节介绍如何向线程池提交任务，
 * 并获得任务的执行结果。
 * 然后模拟 线程池中的线程在执行任务的过程中抛出异常时，该如何处理。
 * 计算阶乘：
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

        Random random = new Random();
        for (int i = 0; i < 10; i ++) {
            int rand = random.nextInt(10);      //随机生成一个10以内的整数

//            然后创建一个 FactorialCalculator对象，该对象就是待执行的任务，然后在第29行 通过线程池的submit方法提交。
            FactorialCalculator factorialCalculator = new FactorialCalculator(rand);
//            需要注意的是：submit方法是个非阻塞方法，
//            提交了任务后，由线程池里面的线程负责执行该任务，
//            执行完成后得到的结果最终会保存在 Future<Integer>里面，正如第29行所示
            Future<Integer> res = executor.submit(factorialCalculator);//异步提交, non blocking.
            resultList.add(res);
        }

        // in loop check out the result is finished
        do {
//            System.out.printf("number of completed tasks: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Task %d : %s \n", i, result.isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());


        System.out.println("Results as folloers:");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;

            try {
                number = result.get();// blocking method
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("task: %d, result %d:\n", i, number);
        }
        executor.shutdown();
    }
}
