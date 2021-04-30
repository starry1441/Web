package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:volatile尝试解决不安全线程
 * User: starry
 * Date: 2021 -04 -29
 * Time: 10:59
 */
public class ThreadDemo30 {

    static class Counter {
        // 定义的私有变量
        private volatile int num = 0;
        // 任务执行次数
        private final int maxSize = 100000;

        //num++;
        public void incrment() {
            for (int i = 0; i < maxSize; i++) {
                num++;
            }
        }

        //num--
        public void decrment() {
            for (int i = 0; i < maxSize; i++) {
                num--;
            }
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.incrment();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            counter.decrment();
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终的执行结果：" + counter.getNum());
    }

}
