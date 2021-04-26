package Work4_25;

/**
 * Created with IntelliJ IDEA.
 * Description:电影开场白
 * User: starry
 * Date: 2021 -04 -25
 * Time: 19:09
 */
public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {
        String context = "我们用大量的时间来睡觉，聊天，吃饭，听歌，看电影，过着极其懒散的生活。就像是某场电影的开场白，年轻的女子穿着极其随意的短衣，吃着冰淇淋，哼着歌，或有一句没一句的聊天，或许安静，或许笑得肆无忌惮。";
        char[] arr = context.toCharArray();
        for(char a : arr) {
            System.out.print(a);
            Thread.sleep(300);
        }
    }

}
