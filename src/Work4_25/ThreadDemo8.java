package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:类2：方法3
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:49
 */
public class ThreadDemo8 {

    public static void main(String[] args) {

        //lambda + 匿名 runnable的实现方式
        Thread thread = new Thread(() -> {
            System.out.println("线程名：" +
                    Thread.currentThread().getName());
        });
        thread.start();

    }

}
