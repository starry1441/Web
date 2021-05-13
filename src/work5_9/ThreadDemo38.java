package work5_9;

/**
 * Created with IntelliJ IDEA.
 * Description:线程通讯
 * User: starry
 * Date: 2021 -05 -09
 * Time: 11:09
 */
public class ThreadDemo38 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入线程方法");
                synchronized (lock) {
                    try {
                        //线程休眠
                        lock.wait();
//                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1：执行完成");
            }
        });
        t1.start();

        Thread.sleep(1000);
        System.out.println("主线程唤醒线程1");

        synchronized (lock) {
            //唤醒线程
            lock.notify();
        }

    }

}
