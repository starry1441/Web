package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:优先级
 * User: starry
 * Date: 2021 -04 -25
 * Time: 21:16
 */
public class ThreadDemo14 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" +
                        Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 6; i++) {
            Thread t1 = new Thread(runnable,"小优先线程");
            Thread t2 = new Thread(runnable,"中优先线程");
            Thread t3 = new Thread(runnable,"大优先线程");

            t1.setPriority(1);  //最小优先级
//            t1.setPriority(Thread.MIN_PRIORITY);
            t3.setPriority(Thread.MAX_PRIORITY);
            t1.start();
            t2.start();
            t3.start();
        }
    }

}
