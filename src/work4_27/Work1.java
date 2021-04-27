package work4_27;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -27
 * Time: 21:43
 */
public class Work1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.print("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 10; i++) {
                System.out.print("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 10; i++) {
                System.out.println("C");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
    }

}
