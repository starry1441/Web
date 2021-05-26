package work5_25;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉模式1
 * User: starry
 * Date: 2021 -05 -25
 * Time: 20:30
 */
public class ThreadDemo85 {

    static class Singleton {
        //1.创建一个私有的构造函数（防止其他地方直接实例化）
        private Singleton() {

        }

        //2.创建一个私有的类对象
        private static Singleton singleton = null;

        //3.提供统一的访问入口（方法）
        public static Singleton getInstance() {
            if (singleton == null) {
                //第一次访问
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建第一个对象
        Singleton s1 = Singleton.getInstance();
        //创建第二个对象
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}
