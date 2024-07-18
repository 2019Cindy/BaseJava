package yy.UDP;

import java.io.IOException;
import java.net.*;

/**
 * 发送方
 */
public class TestSend {
    public static void main(String[] args) throws IOException {
        System.out.println("学生上线。。。");
        // 1.准备套接字
        DatagramSocket ds = new DatagramSocket(8888);
        // 2.准备数据包
        String str = "你好啊！";
        byte[] bytes = str.getBytes();
        // 数据包的四个参数：传送数据转为字节数据，字节数组的长度，接收方的ip，接收方的端口
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9999);
        // 发送
        ds.send(dp);

        // 接收服务器响应的数据
        byte[] bytes1 = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes1, bytes1.length);
        ds.receive(packet);
        byte[] data = packet.getData();
        String res = new String(data,0,bytes1.length);
        System.out.println("响应回来的数据为：" + res);
        // 关闭
        ds.close();
    }
}
