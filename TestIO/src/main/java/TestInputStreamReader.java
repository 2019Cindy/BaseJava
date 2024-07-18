import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流：将字节流和字符流进行转换，转换流属于字符流
 * InputStreamReader:将字节流转为字符流
 * OutputStreamWriter:将字符流转换为字节输出流
 */
public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\test.txt");
        FileInputStream fin = new FileInputStream(file);
        // 将字节流转转换为字符的时候，需要指定编码
        InputStreamReader reader = new InputStreamReader(fin, StandardCharsets.UTF_8);
        FileOutputStream fout = new FileOutputStream("F:\\testCopy.txt");
        OutputStreamWriter writer = new OutputStreamWriter(fout, StandardCharsets.UTF_8);
        char[] chars = new char[20];
        int len = 0;
        while ((len = reader.read(chars)) != -1) {
//            System.out.println(String.valueOf(chars));
            writer.write(chars,0,len);
        }
        writer.close();
        reader.close();
    }
}
