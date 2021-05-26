package work5_25;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -25
 * Time: 18:55
 */
public class ThreadLocalDemo81 {

    //1m 大小的对象
    static class OOMObject {
        private byte[] bytes = new byte[1*10024*1024];
    }
    static ThreadLocal<OOMObject> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    OOMObject oomObject = new OOMObject();
                    // set threadLocal
                    System.out.println("任务" + finalI + "执行了");
                    threadLocal.set(oomObject);
                    // 不用对象了
                    oomObject = null;
                }
            });
            t.start();
            Thread.sleep(200);
        }
    }

}
