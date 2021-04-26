package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:创建进程方式：继承Thread类
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:34
 */

public class ThreadDemo4 {

    static class MyThread extends Thread {
        @Override
        public void run() {
            //线程执行任务
            System.out.println("线程名称：" +
                    Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //创建了线程
        Thread t1 = new MyThread();
        //运行新线程
        t1.start();
        System.out.println("当前线程的名称(主线程)：" +
                Thread.currentThread().getName());
    }

}
