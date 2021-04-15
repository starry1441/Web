package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:客户端
 * User: starry
 * Date: 2021 -04 -13
 * Time: 21:07
 */

public class UDPClient {

    //服务器的ip地址
    private static final String ip = "82.156.229.239";
    //服务器的端口号
    private static final int port = 9001;
    //数据的最大值
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        //1.启动客户端
        DatagramSocket client = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("我：");
            String msg = scanner.nextLine();
            //2.给服务器发送消息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            //3.接收服务器的返回信息
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            //接收到服务器端返回信息
            String serMsg = new String(serPacket.getData());
            System.out.println("对方："+serMsg);
        }
    }

}
