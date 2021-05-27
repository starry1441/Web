package work5_27;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:AA问题
 * User: starry
 * Date: 2021 -05 -27
 * Time: 19:49
 */
public class ThreadDemo92 {

    private static AtomicReference money = new AtomicReference(100);

    public static void main(String[] args) {
        //转正线程1（-100）
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean res = money.compareAndSet(100,0);
                System.out.println("第一次转账：" + res);
            }
        });
        t1.start();

        //转正线程2（-100）
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean res = money.compareAndSet(100,0);
                System.out.println("第二次转账：" + res);
            }
        });
        t2.start();

    }

}
