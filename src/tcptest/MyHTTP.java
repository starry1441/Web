package tcptest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义http服务器
 * User: starry
 * Date: 2021 -04 -17
 * Time: 20:22
 */
public class MyHTTP {

    //端口号
    private static final int port = 9004;

    public static void main(String[] args) throws IOException {
        //1. 创建一个 TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动~");

        //2. 等待客户端连接
        Socket socket = serverSocket.accept();

        //3. 构建读写对象
        try(
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                )
                ) {
            //4. 得到客户端信息
            //得到首行信息
            String firstLine = reader.readLine();
            String[] firstLineArr = firstLine.split(" ");
            //方法类型
            String method = firstLineArr[0];
            //uri
            String uri = firstLineArr[1];
            //http 版本号
            String httpVersion = firstLineArr[2];
            System.out.println(String.format("首行信息 -> 方法类型：%s，URI：%s，HTTP版本号：%s",
                    method,uri,httpVersion));

            //5.构建返回内容
            String content = "";
            if(uri.contains("404")) {
                content = "<h1>没有找到此页面</h1>";
            }
            if(uri.contains("200")) {
                content = "<h1>你好，世界</h1>";
            }
            if(uri.contains("500")) {
                content = "<h1>服务器遇到意外</h1>";
            }

            //6. 内容输出
            //输出首行信息
            writer.write(String.format("%s 200 ok",httpVersion)+"\n");
            //输出head
            writer.write("Content-Type: text/html;charset=utf-8\n");
            writer.write("Content-Length: "+content.getBytes().length+"\n"); //这里必须是字节长度
            //输出空行
            writer.write("\n");
            writer.write(content);
            writer.flush();

        }

    }

}
