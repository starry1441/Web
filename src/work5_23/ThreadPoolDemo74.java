package work5_23;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -23
 * Time: 15:48
 */
public class ThreadPoolDemo74 {

    public static void main(String[] args) {
        //模拟用户的登录操作
        User user = new User();
        user.setUsername("Java");
        ThreadLocalUtil.threadLocal.set(user);

        //调用订单系统
        Order order = new Order();
        order.getOrder();;

        //调用日志系统
        Logger logger = new Logger();
        logger.addLog();

    }

    static class ThreadLocalUtil {
        static ThreadLocal<User> threadLocal = new ThreadLocal<>();
    }

    static class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    /**
     * 日志模块
     */
    static class Logger {
        public void addLog() {
            // 得到用户信息
            User user = ThreadLocalUtil.threadLocal.get();
            //...
            System.out.println("添加日志：" + user.getUsername());
        }
    }

    static class Order {
        public void getOrder() {
            User user = ThreadLocalUtil.threadLocal.get();
            //...
            System.out.println("订单列表：" + user.getUsername());
        }
    }

}
