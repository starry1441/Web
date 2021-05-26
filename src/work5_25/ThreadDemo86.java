package work5_25;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉模式1--证明
 * User: starry
 * Date: 2021 -05 -25
 * Time: 20:30
 */
public class ThreadDemo86 {

    static class Singleton {
        //1.创建一个私有的构造函数（防止其他地方直接实例化）
        private Singleton() {

        }

        //2.创建一个私有的类对象
        private static Singleton singleton = null;

        //3.提供统一的访问入口（方法）
        public static Singleton getInstance() {
            if (singleton == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第一次访问
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    private static Singleton s1 = null;
    private static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {
        //创建新线程执行任务
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1 = Singleton.getInstance();
            }
        });
        t1.start();

        //使用主线程执行任务
        s2 = Singleton.getInstance();
        //等待t1执行完
        t1.join();

        System.out.println(s1 == s2);
    }

}
