package work5_23;

import java.text.SimpleDateFormat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 15:29
 */
public class ThreadPoolDemo73 {
    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("mm-ss"));

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, 
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 10; i++) {
            
        }
    }
}
