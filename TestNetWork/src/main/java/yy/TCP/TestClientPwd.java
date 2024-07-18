package yy.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用户名、密码进行校验
 */
public class TestClientPwd {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.88.5", 9999);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请分别输入用户名和密码：");
        String name = scanner.next();
        String pwd = scanner.next();
        User user = new User(name, pwd);
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(user);

        // 接收服务器返回的结果
        InputStream in = socket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        String s = din.readUTF();
        System.out.println(s);

        in.close();
        out.close();
        socket.close();
    }
}
