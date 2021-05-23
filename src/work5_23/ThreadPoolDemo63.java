package work5_23;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 10:58
 */
public class ThreadPoolDemo63 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (10,10,0,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("编号：%d，线程名你：%s" ,finalI,Thread.currentThread().getName()));
                }
            });
        }
    }

}
