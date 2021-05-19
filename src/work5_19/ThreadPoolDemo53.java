package work5_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -19
 * Time: 21:12
 */
public class ThreadPoolDemo53 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
        
        // 等待异步线程池执行完成，（根据线程的终止状态）
        while (!service.isTerminated()) {

        }
    }

}
