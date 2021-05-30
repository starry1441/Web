package work5_30;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -30
 * Time: 10:52
 */
public class ThreadDemo101 {

    public static void main(String[] args) {
        //非线程安全的
        HashMap hashMap = new HashMap();

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    }

}
