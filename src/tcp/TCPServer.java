package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:服务器端
 * User: starry
 * Date: 2021 -04 -15
 * Time: 19:27
 */
public class TCPServer {

    //端口号
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {
        //1.创建并启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动");
        //2.等待客户端链接
        Socket clientSocket = serverSocket.accept();
        //当执行到这一步，表示已经有客户端连接
        System.out.println(String.format("已有客户端，IP：%s，端口号：%d",
                clientSocket.getInetAddress().getHostAddress(),
                clientSocket.getPort()));

        //3.收、发消息
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            //接收客户端消息
            String msg = reader.readLine();
            System.out.println("接收到客户端消息："+msg);
        }finally {
            if(reader != null) {
                reader.close();
            }
        }

        //给客户端一个反馈消息
        String serMsg = "我收到了";
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );
            writer.write(serMsg+"\n");  //\n不能省略（因为读取的时候是按行读取）
        }finally {
            if(writer != null) {
                writer.close();
            }
        }

        //发送缓冲区刷新操作（执行此步骤意味着立马将缓冲区的消息发送出去）
        writer.flush();
    }

}
