package yy.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class TestServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已启动");
        // 等待客户端发送过来的信息
        // accept返回值为一个Socket，这个Socket就是客户端的Socket，接收到Socket后客户端和服务器才真正产生了连接，可以进行通信了
        Socket socket = serverSocket.accept();// 阻塞，等待接收客户端的数据，什么时候接收到数据，什么时候程序向下执行
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        // 获取客户端发送过来的数据
        String s = din.readUTF();
        System.out.println("客户端发送的数据：" + s);

        // 向客户端输出
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeUTF("已接收到数据");

        // 关闭流
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}

class TestThread {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int count = 0;// 计数，客户端请求次数
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {  // 死循环，服务器一直监听客户端
                socket = serverSocket.accept();
                // 每次传过来的客户端请求，需要通过线程处理
                Thread thread = new TestServerThread(socket);
                thread.start();
                count++;
                System.out.println("当前是第" + count + "个用户请求，客户端IP为：" + socket.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
