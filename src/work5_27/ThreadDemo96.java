package work5_27;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -27
 * Time: 20:47
 */
public class ThreadDemo96 {

    public static void main(String[] args) {
        //创建一个读写锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        //读锁
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        //线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));

        //任务1：读锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try {
                    //业务逻辑处理
                    System.out.println(Thread.currentThread().getName() + "执行了读操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    readLock.unlock();
                }
            }
        });

        //任务2：读锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try {
                    //业务逻辑处理
                    System.out.println(Thread.currentThread().getName() + "执行了读操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    readLock.unlock();
                }
            }
        });

        //任务3：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                writeLock.lock();
                try {
                    //业务逻辑处理
                    System.out.println(Thread.currentThread().getName() + "执行了读操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    writeLock.unlock();
                }
            }
        });

        //任务4：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                writeLock.lock();
                try {
                    //业务逻辑处理
                    System.out.println(Thread.currentThread().getName() + "执行了读操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放锁
                    writeLock.unlock();
                }
            }
        });
    }

}
