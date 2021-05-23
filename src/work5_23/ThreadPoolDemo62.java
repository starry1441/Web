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
public class ThreadPoolDemo62 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5,5,0,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(5));
        //返回返回值
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println("线程池生成了随机数：" + num);
                return num;
            }
        });
        System.out.println("main得到返回值" + future.get());
        executor.shutdown();
    }

}
