package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:第一类：方法二
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:39
 */
public class ThreadDemo5 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("线程名：" +
                        Thread.currentThread().getName());
            }
        };
        thread.start();
    }

}
