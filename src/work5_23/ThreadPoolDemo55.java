package work5_23;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 9:24
 */
public class ThreadPoolDemo55 {

    public static void main(String[] args) {
        //原始的创建线程池的方法
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5,5,60,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名" + Thread.currentThread().getName());
                }
            });
        }
    }

}
