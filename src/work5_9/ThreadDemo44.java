package work5_9;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -13
 * Time: 17:04
 */
public class ThreadDemo44 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程进入休眠：" + new Date());
                LockSupport.parkUntil(System.currentTimeMillis() + 1000);
                System.out.println("线程终止休眠：" + new Date());
            }
        }).start();
    }

}
