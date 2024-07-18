package yy.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerPwd {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        ObjectInputStream objIn = new ObjectInputStream(in);
        User user = (User) objIn.readObject();
        String name = user.getName();
        String pwd = user.getPwd();
        System.out.println("用户名为：" + name + ",密码为：" + pwd);

        // 服务器校验后返回结果
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        if(name.equals("hhh") && pwd.equals("123")){
            dout.writeUTF("登录成功！");
        }else
            dout.writeUTF("用户名密码错误，请重新登录！");

        out.close();
        in.close();
        socket.close();
        serverSocket.close();

    }
}
