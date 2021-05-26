package work5_25;

/**
 * Created with IntelliJ IDEA.
 * Description:饿汉方式
 * User: starry
 * Date: 2021 -05 -25
 * Time: 20:18
 */



public class ThreadDemo84 {

    static class Singleton {
        //1.创建私有的构造函数(防止其他类直接创建)
        private Singleton() {

        }

        //2.定义私有变量(线程安全)
        private static Singleton singleton = new Singleton();

        //3.提供公共的获取实例的方法
        public static Singleton getInstance() {
            return singleton;
        }

    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }

}
