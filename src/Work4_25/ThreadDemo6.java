package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:第二类：方法一
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:44
 */
public class ThreadDemo6 {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("线程名：" +
                    Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //1.新建 Runnable 类
        MyRunnable runnable = new MyRunnable();
        //2.新建 Thread
        Thread thread = new Thread(runnable);
        //3.启动线程
        thread.start();
    }

}
