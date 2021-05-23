package work5_23;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 14:59
 */
public class ThreadPoolDemo71 {

    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Java");

    public static void main(String[] args) {
        try {
            String result = threadLocal.get();
            System.out.println("结果:" + result);
        }finally {
            threadLocal.remove();
        }

    }

}
