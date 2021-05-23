package work5_23;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 9:59
 */
public class ThreadPoolDemo60 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 5, 0,
                        TimeUnit.SECONDS, new LinkedBlockingDeque<>(5),
                        new RejectedExecutionHandler() {
                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                                //自定义拒绝策略
                                System.out.println("执行了自定义拒绝策略");
                            }
                        });
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
