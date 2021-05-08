package work5_8;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -08
 * Time: 17:02
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("c");
                }
            }
        });
        c.start();

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("b");
                }
            }
        });
        b.start();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("a");
                }
            }
        });
        a.start();

    }

}
