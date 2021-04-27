package Work4_25;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:显示线程分组
 * User: starry
 * Date: 2021 -04 -25
 * Time: 20:57
 */
public class ThreadDemo12 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始起跑了" +
                        Thread.currentThread().getName());
                int num = 1 + new Random().nextInt(5);
                try {
                    Thread.sleep(num * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我到终点了：" +
                        Thread.currentThread().getName());
            }
        };
        //定义分组
        ThreadGroup group = new ThreadGroup("百米赛跑第一组");

        //创建运动
        Thread t1 = new Thread(group,runnable,"张三");
        Thread t2 = new Thread(group,runnable,"李四");
        t1.start();
        t2.start();

        // 打印线程分组的详情
//        group.list();

        //等待所有选手到达
        while (group.activeCount() != 0) {

        }

        //宣布成绩
        System.out.println("宣布成绩");
    }

}
