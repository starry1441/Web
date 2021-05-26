package work5_25;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -25
 * Time: 21:16
 */
public class ThreadDemo89 {

    static class MyBlockingQueue {
        private int[] values;   //实际存储数据的数组
        private int first;  //队首
        private int last;   //队位
        private int size;   //队列元素的实际大小

        public MyBlockingQueue(int initial) {
            //初始化变量
            values = new int[initial];
            first = 0;
            last = 0;
            size = 0;
        }

        //添加元素(队尾)【生产者】
        public void offer(int val) {
            synchronized (this) {
                //判断边界值
                if (size == values.length) {
                    //队列已满
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //添加元素到队尾
                values[last] = val;
                last++;
                size++;
                //判断是否为最后一个元素
                if (last == values.length) {
                    last = 0;
                }
                // 尝试唤醒消费者
                this.notify();
            }
        }

        //弹出元素（队首）【消费者】
        public int poll() {
            int result = -1;
            synchronized (this) {
                //判断边界值
                if (size == 0) {
                    //队列为空，阻塞等待
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //取元素
                result = values[first];
                first++;
                size--;
                //处理是否为最后一个元素
                if (first == values.length) {
                    first = 0;
                }
                //尝试唤醒生产者
                this.notify();;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue(5);

        //创建生产者
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //每隔 500ms 生产一条数据
                while (true) {
                    int num = new Random().nextInt(10);
                    System.out.println("生产了随机数：" + num);
                    queue.offer(num);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        //创建消费者
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int result = queue.poll();
                    System.out.println("消费了数据：" + result);
//                    int t = new Random().nextInt(1000);
//                    try {
//                        Thread.sleep(t);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        t2.start();
    }

}
