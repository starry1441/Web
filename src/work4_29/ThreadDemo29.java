package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:解决内存不可见问题
 * User: starry
 * Date: 2021 -04 -29
 * Time: 11:37
 */
public class ThreadDemo29 {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {

                }
                System.out.println("终止执行");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("设置 flag 为 true");
                flag = true;
            }
        });
        t2.start();

    }


}
