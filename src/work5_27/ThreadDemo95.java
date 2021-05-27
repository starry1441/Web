package work5_27;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Description:解决ABA问题
 * User: starry
 * Date: 2021 -05 -27
 * Time: 19:49
 */
public class ThreadDemo95 {

    private static AtomicStampedReference money = new AtomicStampedReference(1000,1);

//    private static AtomicReference money = new AtomicReference(100);

    public static void main(String[] args) throws InterruptedException {
        //转正线程1（-1000）
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean res = money.compareAndSet(1000,0,1,2);
                System.out.println("第一次转账：" + res);
            }
        });
        t1.start();

        t1.join();

        //转入1000元
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //+100
                boolean res = money.compareAndSet(0,1000,2,3);
                System.out.println("转入100元：" + res);
            }
        });
        t3.start();
        
        t3.join();

        //转正线程2（-1000）
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean res = money.compareAndSet(1000,0,1,2);
                System.out.println("第二次转账：" + res);
            }
        });
        t2.start();

    }

}
