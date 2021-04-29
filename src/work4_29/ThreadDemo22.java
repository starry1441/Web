package work4_29;

/**
 * Created with IntelliJ IDEA.
 * Description:所有线程状态
 * User: starry
 * Date: 2021 -04 -29
 * Time: 10:09
 */
public class ThreadDemo22 {

    public static void main(String[] args) {
        //打印所有线程
        for (Thread.State item : Thread.State.values()) {
            System.out.println(item);
        }
    }

}
