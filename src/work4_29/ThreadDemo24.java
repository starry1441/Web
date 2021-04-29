package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:yield
 * User: starry
 * Date: 2021 -04 -29
 * Time: 10:52
 */
public class ThreadDemo24 {
    private static final int maxSize = 1000;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < maxSize; i++) {
                //出让 CPU 执行权
                Thread.yield();
                System.out.println("我是t1");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < maxSize; i++) {
                System.out.println("我是t2");
            }
        });
        t2.start();
    }

}
