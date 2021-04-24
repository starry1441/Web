package Work4_24;

/**
 * Created with IntelliJ IDEA.
 * Description:第一个线程的创建
 * User: starry
 * Date: 2021 -04 -24
 * Time: 16:34
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60*60*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
    }
}
