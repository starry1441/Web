package work4_29;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:Lock公平锁实现
 * User: starry
 * Date: 2021 -05 -01
 * Time: 20:40
 */
public class ThreadDemo34 {

    public static void main(String[] args) throws InterruptedException {
        //声明一个公平锁
        Lock lock = new ReentrantLock(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(char item : "ABCD".toCharArray()) {
                    lock.lock();
                    try {
                        System.out.print(item);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");

        //等一会时间，让两个线程都初始化完
        Thread.sleep(10);

        t1.start();
        t2.start();
    }

}
