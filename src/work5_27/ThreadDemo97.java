package work5_27;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -27
 * Time: 21:06
 */
public class ThreadDemo97 {

    //创建锁
    private static Object lock = new Object();

    public static void main(String[] args) {
        //第一次进入锁
        synchronized (lock) {
            System.out.println("第一次进入锁");
            synchronized (lock) {
                System.out.println("第二次进入锁");
            }
        }
    }

}
