package work4_28;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * Description:不休眠情况下
 * User: starry
 * Date: 2021 -04 -28
 * Time: 16:31
 */
public class ThreadDemo19 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    System.out.println("正转账呢");
                }
                System.out.println("终止转账");
            }
        });
        t1.start();

        Thread.sleep(10);
        System.out.println("有内鬼，终止交易");
        t1.interrupt();
    }

}
