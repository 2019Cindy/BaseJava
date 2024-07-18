import java.io.*;

/**
 * 数据流：DataInputStream、DataOutputStream
 * DataInputStream：将内存中的基本数据类型和字符串变量 写出到文件中
 */
public class TestDataIO {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("F:\\dataIO.txt")));
        dos.writeInt(89);
        dos.writeUTF("哈哈哈发生发射点发");
        dos.writeDouble(12.9);
        dos.close();

        // 写出的类型必须和读入的类型匹配
        DataInputStream din = new DataInputStream(new FileInputStream("F:\\dataIO.txt"));
        System.out.println(din.readInt());
        System.out.println(din.readUTF());
        System.out.println(din.readDouble());
        din.close();
    }
}
