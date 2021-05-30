package work5_30;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:计数器
 * User: starry
 * Date: 2021 -05 -30
 * Time: 9:44
 */
public class ThreadDemo99 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

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
                    //计数器-1
                    latch.countDown();
                }
            }).start();
        }
        //阻塞等待
        latch.await();
        System.out.println("所有人都到达了终点，公布排名");
    }

}
