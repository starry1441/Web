package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:线程状态
 * User: starry
 * Date: 2021 -04 -29
 * Time: 10:19
 */
public class ThreadDemo23 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("没调用start之前的状态：" + t1.getState());
        t1.start();
        System.out.println("调用start之后的状态：" + t1.getState());
        Thread.sleep(100);  //确保t1线程在休眠期间，主线程先休眠一会
        System.out.println("t1的状态：" + t1.getState());

        //等待线程执行完成
        t1.join();
        //也可以让主线程空转来等待t1结束
//        while (!t1.isAlive()) {
//        }
        System.out.println("t1线程执行完成之后的状态:" + t1.getState());
    }

}
