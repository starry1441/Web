package work5_30;

import java.util.concurrent.BrokenBarrierException;
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
                    //
                    try {
                        System.out.println(Thread.currentThread().getName() + "等待其他人---");
                        //计数器-1，判断计数器是否为0
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    // 代码执行到此行，说明已经有一组线程满足条件了
                    System.out.println(Thread.currentThread().getName() + "执行结束。。。");
                }
            }).start();
        }

    }
}
