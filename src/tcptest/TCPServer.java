package tcptest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:服务器端
 * User: starry
 * Date: 2021 -04 -16
 * Time: 16:20
 */
public class TCPServer {

    //端口号
    private static final int port = 9002;

    static Map<String,String> map = new HashMap<>();
    static {
        map.put("星星","star");
        map.put("星空","starry");
        map.put("骑士","knight");
        map.put("大树","tree");
        map.put("亮光","light");
    }

    public static void main(String[] args) throws IOException {
        //1.启动服务器，设置服务器端口号
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动");

        //2.等待客户端链接
        Socket socket = serverSocket.accept();
        //执行到这一步后，就有客户端连接上了,输出打印客户端信息
        System.out.println(String.format("客户端的ip地址为：%s,端口号为：%d",
                socket.getInetAddress().getHostAddress(),
                socket.getPort()));

        //3.收发信息
        try(
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                )
                ){
            while(true) {
                //接收客户端的消息
                String msg = reader.readLine();
                //非空效验
                if(msg != null && !msg.equals("")) {
                    System.out.println("客户端："+msg);

                    //给客户端反馈一个消息
                    String serMsg = transform(msg);
                    writer.write(serMsg+"\n");  //\n不能省略（因为读取的时候是按行读取）

                    //发送缓冲区刷新操作（执行此步骤意味着立马将缓冲区的消息发送出去）
                    writer.flush();
                }
            }

        }

    }

    private static String transform(String msg) {
        String cn = map.get(msg);
        return cn == null? "未知":cn;
    }

}
