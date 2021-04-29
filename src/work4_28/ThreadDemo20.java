package work4_28;

/**
 * Created with IntelliJ IDEA.
 * Description:Thread.interrupted()和Thread.currentThread().isInterrupted()的区别
 * User: starry
 * Date: 2021 -04 -28
 * Time: 16:40
 */
public class ThreadDemo20 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t1.start();

        t1.interrupt();

    }

}
