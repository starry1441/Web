package work5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -19
 * Time: 20:58
 */
public class ThreadPoolDemo52 {

    public static void main(String[] args) {
        //创建单个执行定时任务的线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        //开启定时任务
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }

}
