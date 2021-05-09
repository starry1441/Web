package work5_9;

/**
 * Created with IntelliJ IDEA.
 * Description:死锁
 * User: starry
 * Date: 2021 -05 -09
 * Time: 10:00
 */
public class ThreadDemo36 {

    public static void main(String[] args) {
        //锁A（资源A）
        Object lockA = new Object();
        //锁B（资源B）
        Object lockB = new Object();
        //线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程1：得到了锁A");
                    try {
                        //休眠1s，让线程2先得到锁B
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1：等待获取锁B");
                    //尝试获取锁B
                    synchronized (lockB) {
                        System.out.println("线程1：得到了锁B");
                    }
                }
            }
        },"t1");
        t1.start();

        //创建并启动线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    System.out.println("线程2：得到了锁B");
                    try {
                        //休眠1s，让线程1先得到锁A
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2：等待获取锁A");
                    //尝试获取锁B
                    synchronized (lockA) {
                        System.out.println("线程2：获取到锁A");
                    }
                }
            }
        },"t2");
        t2.start();
    }

}
