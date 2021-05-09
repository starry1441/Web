package work5_9;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -09
 * Time: 11:48
 */
public class ThreadDemo40 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程1：拥有了锁lock，进入休眠状态");
                    try {
                        //线程休眠
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread.sleep(1000);
    }

}
