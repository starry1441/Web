package work5_23;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 9:59
 */
public class ThreadPoolDemo59_4 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5,5,0,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(5),
                        new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 11; i++) {
            int finlI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务"+finlI+"，线程名"+Thread.currentThread().getName());
                }
            });
        }
    }

}
