package yy.TCP;

import java.io.*;
import java.net.Socket;

/**
 * 多线程，用于处理客户端的请求
 */
public class TestServerThread extends Thread {
    Socket socket;
    ObjectInputStream oin = null;
    DataOutputStream dout = null;

    public TestServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            oin = new ObjectInputStream(in);
            User user = (User) oin.readObject();
            System.out.println(user.getName() + "===" + user.getPwd());
            OutputStream out = socket.getOutputStream();
            dout = new DataOutputStream(out);
            if (user.getName().equals("aaa") && user.getPwd().equals("111")) {
                dout.writeUTF("登录成功！");
            } else
                dout.writeUTF("登录失败，请重新登录！");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                dout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
