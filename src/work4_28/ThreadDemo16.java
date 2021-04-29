package work4_28;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:创建线程
 * User: starry
 * Date: 2021 -04 -28
 * Time: 15:36
 */
public class ThreadDemo16 {

    static class myThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    public static void main(String[] args) {

//        Thread thread = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("当前时间：" + new Date());
//        },"星星");

        Thread thread = new myThread();
        thread.setName("星星");

        thread.start();
        thread.run();
    }

}
