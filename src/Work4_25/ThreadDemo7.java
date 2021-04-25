package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:第二类：方法二
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:47
 */
public class ThreadDemo7 {

    public static void main(String[] args) {
        //匿名内部类的方式实现线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" +
                        Thread.currentThread().getName());
            }
        });
        thread.start();
    }

}
