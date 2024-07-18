import java.io.*;
import java.util.Scanner;

/**
 * System 对IO流的支持
 */
public class TestSystemIO {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
/*        int read = in.read();   // read方法等待键盘的录入，是一个阻塞方法
        System.out.println(read);*/

        // 由以上代码实践得知，键盘录入实际上是System.in
        // scanner扫描器：起扫描的占作用，扫键盘从这个管输入的内容
    /*    Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);*/

        Scanner sc = new Scanner(new FileInputStream(new File("F:test.txt")));
        while (sc.hasNext()){
            System.out.println(sc.next());
        }

        System.out.println("=================输出流===================");
        PrintStream out = System.out;
        out.println("hhhh");
        out.println("啊啊啊啊吗");
    }
}


// 将控制台的输入写入文件中
class TestSystemIOCopy {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("F:\\system.txt")));
        String str;
        while (!(str = reader.readLine()).equals("exit")) {
            writer.write(str);
            writer.newLine();
        }
        writer.close();
        reader.close();
    }
}