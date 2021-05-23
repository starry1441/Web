package work5_23;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 14:59
 */
public class ThreadPoolDemo70 {

    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了初始化方法");
            return "Java";
        }
    });

    public static void main(String[] args) {
        String result = threadLocal.get();
        System.out.println("结果:" + result);
    }

}
