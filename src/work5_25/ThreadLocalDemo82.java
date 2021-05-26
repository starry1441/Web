package work5_25;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -25
 * Time: 18:55
 */
public class ThreadLocalDemo82 {

    //1m 大小的对象
    static class OOMObject {
        private byte[] bytes = new byte[1*10024*1024];
    }
    static ThreadLocal<OOMObject> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,0,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    OOMObject oomObject = new OOMObject();
                    // set threadLocal
                    System.out.println("任务" + finalI + "执行了");
                    threadLocal.set(oomObject);
                    // 不用对象了
                    oomObject = null;
                }
            });
            Thread.sleep(200);
        }
    }

}
