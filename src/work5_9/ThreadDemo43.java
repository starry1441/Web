package work5_9;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:lockSupport正确感知interrupt
 * User: starry
 * Date: 2021 -05 -13
 * Time: 16:57
 */
public class ThreadDemo43 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程休眠前状态：" +
                        Thread.interrupted());
                LockSupport.park();
                System.out.println("线程休眠后状态：" +
                        Thread.interrupted());
            }
        });
        t1.start();

        Thread.sleep(1000);

        //终止线程
        t1.interrupt();
        LockSupport.unpark(t1);

    }

}
