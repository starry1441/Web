package work5_30;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description:循环屏障
 * User: starry
 * Date: 2021 -05 -30
 * Time: 10:15
 */
public class ThreadDemo100 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了CyclicBarrier里面的Runnable");
            }
        });

        for (int i = 1; i < 11; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "开始起跑");
                    try {
                        Thread.sleep(1000 * finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread.sleep(finalI * 1000);

        }

        for (int i = 1; i < 6; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "开始起跑");
                    try {
                        Thread.sleep(finalI * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "到达终点");
                }
            }).start();
        }

    }
}
