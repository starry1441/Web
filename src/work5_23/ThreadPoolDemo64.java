package work5_23;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 11:38
 */
public class ThreadPoolDemo64 {

    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println("未格式化之前:"+ date);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String result = dateFormat.format(date);
//        System.out.println("格式化之后：" + result);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                //执行事件格式化并打印结果
                myFormatTime(date);
            }
        });
        t1.start();

    }

    private static void myFormatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = dateFormat.format(date);
    }

}
