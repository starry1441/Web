package work5_23;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 12:05
 */
public class ThreadPoolDemo67 {

    // 创建 ThreadLocal
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // set 设置 threadLocal
                String tname = Thread.currentThread().getName();
                threadLocal.set(tname);
                System.out.println(String.format("线程：%s，设置了值：%s",tname,tname));
            }
        },"线程1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String tname = Thread.currentThread().getName();
            }
        });
    }

    private static void printTName() {
        String tname = Thread.currentThread().getName();
        // 得到存放在 ThreadLoca 中的值
//        String result =
    }

}
