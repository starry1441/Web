package work5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -19
 * Time: 19:34
 */
public class ThreadPoolDemo45_2 {

    public static void main(String[] args) {
        //创建固定个数的线程池
        ExecutorService service = Executors.newFixedThreadPool(1);//5:复用线程
        //执行任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
        };
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);
        service.execute(runnable);

    }

}
