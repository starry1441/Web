package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -25
 * Time: 21:28
 */
public class ThreadDemo15 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("i:" + i);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            Thread t2 = new Thread(() -> {});
            System.out.println(t2.isDaemon());
        });
        //设置为守护线程
        t1.setDaemon(true);
        t1.start();
        System.out.println("t1是否为守护线程：" + t1.isDaemon());
    }

}
