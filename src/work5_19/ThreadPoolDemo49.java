package work5_19;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -19
 * Time: 20:41
 */
public class ThreadPoolDemo49 {

    public static void main(String[] args) {
        // 创建一个执行定时任务的线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        System.out.println("执行任务之前：" + new Date());
        // 执行任务
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务：" + new Date());
            }
        },3, TimeUnit.SECONDS);
    }

}
