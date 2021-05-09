package work5_9;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:自己醒来
 * User: starry
 * Date: 2021 -05 -09
 * Time: 11:09
 */
public class ThreadDemo39 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入休眠"+new Date());
                synchronized (lock) {
                    try {
                        //线程休眠
                        lock.wait();
//                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1：执行完成"+new Date());
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入休眠"+new Date());
                synchronized (lock) {
                    try {
                        //线程休眠
                        lock.wait();
//                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1：执行完成"+new Date());
            }
        });
        t2.start();

        Thread.sleep(2000);
        System.out.println("主线程唤醒线程1");

        synchronized (lock) {
            //唤醒线程
            lock.notifyAll();
        }

    }

}
