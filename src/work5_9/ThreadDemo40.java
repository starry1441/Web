package work5_9;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:wait释放锁，sleep不释放锁
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
//                    try {
//                        //线程休眠
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行完成，释放锁lock");
                }
            }
        });
        t1.start();

        Thread.sleep(1000);

        //主线程试图获取到锁Lock
        synchronized (lock) {
            System.out.println("主线程获取到锁lock");
        }
    }
}
