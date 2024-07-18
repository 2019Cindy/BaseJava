import java.io.*;

/**
 * 处理流：管套管
 */
public class TestBufferedIn {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\pic.png");
        // 缓冲字节流
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("F:\\picCopy.png"));
        byte[] bytes = new byte[1024];
        int len=0;
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }

        // 如果处理流包裹着节点流，其实只需要关闭高级流（处理流），里面的字节流也会随之关闭
        out.close();
        in.close();
    }
}

class TestBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("F:\\test.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\testCopy.txt"));
        // 缓冲数组
        /*        char[] chars = new char[1024];
        int len=0;
        while ((len=reader.read(chars))!=-1){
            writer.write(chars);
        }*/

        // 读取string
        String s; //readLine()每次读取文本中的一行返回字符串
        while ((s = reader.readLine()) != null) {
            writer.write(s);
            writer.newLine();   // 新起一行
        }

        writer.close();
        reader.close();
    }

}