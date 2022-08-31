package FacTorialCal;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 计算阶乘：如果number大于5，那么 if(i==5)成立，会抛出异常。即模拟  执行5 以上的阶乘时，会抛出异常。
 */
public class FactorialCalculator implements Callable<Integer> {

    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    public Integer call() throws Exception {
        int result = 1;
        if (number == 0 || number == 1) {
            result = 1;
        } else {
            for (int i = 2; i < number; i++) {
                result *= i;
                TimeUnit.MICROSECONDS.sleep(200);
                if (i == 5) {
                    throw new IllegalArgumentException("excepion happend");
                    //计算5以上的阶乘都会抛出异常. 根据需要注释该if语句
                }
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
