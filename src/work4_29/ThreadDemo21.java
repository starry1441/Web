package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description: join
 * User: starry
 * Date: 2021 -04 -29
 * Time: 9:26
 */
public class ThreadDemo21 {

    public static void main(String[] args) throws InterruptedException {

        //定义公共任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "上班");
                try {
                    //表示工作时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        "下班");
            }
        };

        //定义星星线程
        Thread t1 = new Thread(runnable,"星星");
        t1.start();

        //等待星星执行完成
        t1.join();
//        t1.join(900);

        //定义狒狒线程
        Thread t2 = new Thread(runnable,"狒狒");
        t2.start();

    }

}
