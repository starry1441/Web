package work4_29;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:不安全线程
 * User: starry
 * Date: 2021 -04 -29
 * Time: 10:59
 */
public class ThreadDemo32 {

    //全局变量
    private static int number = 0;
    //循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {
        //1.创建手动锁
        Lock lock = new ReentrantLock();

        //+10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    //2.加锁
                    lock.lock();
                    try {
                        number++;
                    }finally {
                        //3.释放锁
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();

        //-10w
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number--;
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        t2.start();

        //等t1，t2线程执行完
        t1.join();
        t2.join();

        System.out.println("运行结果为：" + number);
    }


}
