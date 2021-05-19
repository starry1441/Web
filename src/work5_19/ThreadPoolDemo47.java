package work5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:创建带缓存的线程池
 * User: starry
 * Date: 2021 -05 -19
 * Time: 20:06
 */
public class ThreadPoolDemo47 {

    public static void main(String[] args) {
        //创建带缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //执行10个任务
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
