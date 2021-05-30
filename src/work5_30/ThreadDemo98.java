package work5_30;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:信号量
 * User: starry
 * Date: 2021 -05 -30
 * Time: 9:22
 */
public class ThreadDemo98 {

    public static void main(String[] args) {
        //创建信号量
        Semaphore semaphore = new Semaphore(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 4; i++) {
            //创建任务1
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 到达停车场");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //试图进入停车张
                    try {
                        //尝试获取锁
                        semaphore.acquire();
                        //当代码执行到此处说明已经获取到了锁
                        System.out.println(Thread.currentThread().getName() + " 进入停车场----");
                        //车辆停留的时间构建
                        int num = 1 + new Random().nextInt();
                        try {
                            Thread.sleep(num * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "离开停车场。。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //释放锁
                        semaphore.release();
                    }
                }
            });
        }
    }

}
