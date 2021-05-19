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
public class ThreadPoolDemo45 {

    public static void main(String[] args) {
        //创建固定个数的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);//5:复用线程
        //执行任务
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
