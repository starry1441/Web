package work5_23;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 9:49
 */
public class ThreadPoolDemo57 {

    public static int count = 0;

    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("myThreadPool-" + (count++));
                return t;
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5,5,0,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000),threadFactory);

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
