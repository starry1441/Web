package work5_25;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -25
 * Time: 21:16
 */

public class MessageQueue {
    private int[] items;
    private int putIndex;
    private int takeIndex;
    private volatile int size;
    public MessageQueue(int capacity) {
        items = new int[capacity];
        putIndex = 0;
        takeIndex = 0;
        size = 0;
    }
    public void put(int message) throws InterruptedException {
        do {
            synchronized (this) {
                if (size < items.length) {
                    items[putIndex] = message;
                    putIndex = (putIndex + 1) % items.length;
                    size++;
                    notifyAll();
                    return;
                }
            }
            while (size == items.length) {
                synchronized (this) {
                    if (size == items.length) {
                        wait();
                    }
                }
            }
        } while (true);
    }
    public int take() throws InterruptedException {
        do {
            synchronized (this) {
                if (size > 0) {
                    int message = items[takeIndex];
                    takeIndex = (takeIndex + 1) % items.length;
                    size--;
                    notifyAll();
                    return message;
                }
            }while (size == 0) {
                synchronized (this) {
                    if (size == 0) {
                        wait();
                    }
                }
            }
        } while (true);
    }
    public synchronized int size() {
        return size;
    }
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(100);
        Thread producer = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 100_0000_000; i++) {
                try {
                    int a = random.nextInt(100000);
                    queue.put(a);
                    System.out.println("生产"+a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");
        producer.start();
        Thread customer = new Thread(() -> {
            while (true) {
                int message = 0;
                try {
                    message = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费" + message);
            }
        }, "消费者");
        customer.start();
    }
}