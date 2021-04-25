package Work4_25;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -25
 * Time: 21:09
 */
public class ThreadDemo13 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"张三");
        System.out.println("线程状态：" + t1.getState());
        t1.start();
        System.out.println("线程状态：" + t1.getState());
        System.out.println("线程ID：" + t1.getId());
        System.out.println("线程名称：" + t1.getName());
        System.out.println("线程优先级：" + t1.getPriority());
        System.out.println("线程是否为后台进程：" + t1.isDaemon());
        System.out.println("线程是否存活：" + t1.isAlive());
        System.out.println("线程是否被中断：" + t1.isInterrupted());
    }

}
