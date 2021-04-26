package Work4_25;


/**
 * Created with IntelliJ IDEA.
 * Description:进程性能提升
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:10
 */
public class ThreadDemo3 {

    //执行的循环次数
    private static final Long count = 5_0000_0000L;

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(Thread.currentThread().getName());

        //调用多线程方法
        concorrency();

        //调用单线程的方法
        serial();

    }

    //单线程执行方法
    private static void serial() {
        //开始
        Long stime = System.currentTimeMillis();    //记录当前时间毫秒时间戳
//        System.nanoTime();  //记录当前时间的纳秒数（更精确）
        int a = 0;
        for (int i = 0; i < 3 * count; i++) {
            a++;
        }
        Long etime = System.currentTimeMillis();
        System.out.println("单线程执行的时间是" + (etime-stime));
    }

    //多线程的方法
    private static void concorrency() throws InterruptedException {
        //开始时间
        Long stime = System.currentTimeMillis();

        //todo: 执行 30 亿次循环
        //创建了线程任务
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //具体业务
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        //开始执行线程
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        });
        t2.start();

        //让主线程执行 10 亿次
        int c = 0;
        for (int i = 0; i < count; i++) {
            c++;
        }

        //等待线程 t1 和 t2 执行完成之后，才统计时间
        t1.join();
        t2.join();

        Long etime = System.currentTimeMillis();
        System.out.println("多线程执行了" + (etime-stime));

    }

}
