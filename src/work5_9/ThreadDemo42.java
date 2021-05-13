package work5_9;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:自己醒来
 * User: starry
 * Date: 2021 -05 -09
 * Time: 11:09
 */
public class ThreadDemo42 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入休眠"+new Date());
                LockSupport.park();
                System.out.println("线程1：执行完成"+new Date());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2：进入休眠"+new Date());
                LockSupport.park();
                System.out.println("线程2：执行完成"+new Date());
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3：进入休眠"+new Date());
                LockSupport.park();
                System.out.println("线程3：执行完成"+new Date());
            }
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(t1);

        Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(t2);

        Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(t3);


//
//
//
//        Thread.sleep(1000);
//        System.out.println("--------");
//        synchronized (lock) {
//            //唤醒线程
//            lock.notify();
//        }
//
//        Thread.sleep(1000);
//        synchronized (lock) {
//            //唤醒线程
//            lock.notify();
//        }
//
//        Thread.sleep(1000);
//        synchronized (lock) {
//            //唤醒线程
//            lock.notify();
//        }

    }

}
