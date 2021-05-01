package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:加锁解决线程安全
 * User: starry
 * Date: 2021 -04 -29
 * Time: 19:26
 */
public class ThreadDemo31 {
    //全局变量
    private static int number = 0;
    //循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        //+10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock) {
                        number++;
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
                    synchronized (lock) {
                        synchronized (lock) {
                            number--;
                        }
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
