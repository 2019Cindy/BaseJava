package yy.TCP;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        // 创建套接字，指定服务器的IP和端口
        Socket socket = new Socket("192.168.88.5", 8888);
        // 向外发送数据，即 利用输出流，向里面写数据
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeUTF("你好啊");

        // 接收服务器的消息消息
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        String s = din.readUTF();
        System.out.println("接收到服务器返回的数据：" + s);

        // 关闭流
        in.close();
        out.close();
        socket.close();
    }
}
