package MultiThread03;

import org.junit.Test;

/**
 * @ClassName Main
 * @Description TODO
 * @Author shenxinyuan
 * @Date 2021/10/23 $ {TIME}
 * @Version 1. 0
 **/
public class Main {

    public static void main(String[] args) {


        String s1 = "q1";
        String s2 = "q"+1;
        System.out.println(s1 == s2);
        System.out.println(s1.equals( s2));
    }
}
