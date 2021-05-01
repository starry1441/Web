package work4_29;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:将lock（）放在try里面的危害
 * User: starry
 * Date: 2021 -05 -01
 * Time: 19:23
 */
public class ThreadDemo33 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int num = 1/0;
        }finally {
            lock.unlock();
        }
    }

}
