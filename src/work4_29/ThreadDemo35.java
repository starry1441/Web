package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:加锁解决线程安全
 * User: starry
 * Date: 2021 -04 -29
 * Time: 19:26
 */
public class ThreadDemo35 {
    //全局变量
    private static int number = 0;
    //循环次数
    private static final int maxSize = 100000;

    public synchronized void increment() {
        for (int i = 0; i < maxSize; i++) {
            number++;
        }
    }

    public synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo35 threadDemo35 = new ThreadDemo35();

        //+10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo35.increment();
            }
        });
        t1.start();

        //-10w
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo35.decrement();
            }
        });
        t2.start();

        //等t1，t2线程执行完
        t1.join();
        t2.join();

        System.out.println("运行结果为：" + number);
    }


}
