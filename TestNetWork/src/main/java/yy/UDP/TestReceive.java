package yy.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接收方
 */
public class TestReceive {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已开启。。。");
        // 创建套接字
        DatagramSocket ds = new DatagramSocket(9999);
        // 接收数据包
        byte[] bytes = new byte[1024];  // 创建一个空的数据包，用于接收客户端传来的数据
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        // 接收客户端的数据包，放入预留的数据包中
        ds.receive(dp);
        // 取出数据
        byte[] data = dp.getData();
        String res = new String(data, 0, dp.getLength());
        System.out.println("客户端传输过来的数据为：" + res);

        // 接收到数据后，对客户端进行响应
        String str = new String("有什么可以帮助的吗？");
        byte[] bytes1 = str.getBytes();
        // 封装数据，并且指定响应的客户端及端口号
        DatagramPacket packet = new DatagramPacket(bytes1,bytes1.length, InetAddress.getByName("localhost"),8888);
        ds.send(packet);

        // 关闭
        ds.close();
    }
}
