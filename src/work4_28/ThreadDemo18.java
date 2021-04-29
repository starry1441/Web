package work4_28;

/**
 * Created with IntelliJ IDEA.
 * Description:使用 interrupt 来终止线程
 * User: starry
 * Date: 2021 -04 -28
 * Time: 16:06
 */
public class ThreadDemo18 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //判断线程的终止状态
                //!Thread.currentThread().isInterrupted()
                while (!Thread.interrupted()) { //true:终止   //false：继续
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
//                        break;
                    }
                    System.out.println("别烦我，我正在转账");
                }
                System.out.println("终止线程");
            }
        });
        t1.start();

        Thread.sleep(310);
        //终止线程
        System.out.println("有内鬼，终止交易");
        t1.interrupt(); //用来终止线程
    }

}
