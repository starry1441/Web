package tcptest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:客户端
 * User: starry
 * Date: 2021 -04 -16
 * Time: 17:17
 */

public class TCPClient {

    //服务器端口号
    private static final int port = 9002;
    //服务器ip地址
    private static final String ip = "82.156.229.239";

    public static void main(String[] args) throws IOException {
        //1.启动客户端 并 连接到服务器端
        Socket socket = new Socket(ip,port);

        //2.收发消息
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Scanner scanner = new Scanner(System.in);
                ){
            while (true) {
                //给服务器端发送消息
                System.out.print("->");
                //构建消息
                String msg = scanner.nextLine();
                //发送消息
                writer.write(msg+"\n");
                //即刻发送
                writer.flush();

                //接收服务器端的消息
                String serMsg = reader.readLine();
                //非空效验
                if(serMsg != null && !serMsg.equals("")) {
                    System.out.println("服务器端："+serMsg);
                }

            }
        }

    }

}
