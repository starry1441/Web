package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:英译汉翻译器
 * User: starry
 * Date: 2021 -04 -15
 * Time: 20:42
 */
public class TCPServerByCN {

    //端口号
    private static final int port = 9003;

    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("已启动服务器端");

        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println(String.format("已有客户端，IP：%s，端口号：%d"));
    }

}
