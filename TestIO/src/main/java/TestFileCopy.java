import java.io.*;
import java.util.Arrays;

/**
 * 程序完成文件复制---> 字符流 fileReader，fileWriter
 * 注意：文本文件（.txt，.java，.cpp等）建议使用字符流
 *      非文本文件（.jpg，.mp3，.mp4，.doc等）建议使用字节流操作
 */
public class TestFileCopy {
    public static void main(String[] args) throws IOException {
        // 文件读入
        File file = new File("F:\\test.txt");
        FileReader fileReader = new FileReader(file);
        // 以下代码验证了到了文件结尾处，读取的内容为-1
/*        int n1 = fileReader.read();
        int n2 = fileReader.read();
        int n3 = fileReader.read();
        int n4 = fileReader.read();
        int n5 = fileReader.read();
        int n6 = fileReader.read();
        fileReader.close();
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);*/
        // 一个一个读入
        int n;
        while ((n = fileReader.read()) != -1) {
            System.out.println(n + ":" + (char) n);
        }
        fileReader.close();

        System.out.println("========快递员小车：一次性读取多个字节==========");
        FileReader fr = new FileReader(file);
        char[] chars = new char[5];
        int len = 0;
        while ((len = fr.read(chars)) != -1) {
//            System.out.println(chars);
            String str = new String(chars, 0, len);
            System.out.println(str);
        }
        fr.close();

        // 文件输出
        FileWriter fileWriter = new FileWriter("F:\\testCopy.txt",true);    // 追加
        // 一个字符一个字符输出
        String outStr = "hello 你好！";
        for (int i = 0; i < outStr.length(); i++) {
            fileWriter.write(outStr.charAt(i));
        }
        fileWriter.close();

        // 缓冲数组输出
        FileWriter fw = new FileWriter("F:\\testCopy.txt");
        char[] outChars = outStr.toCharArray();
        fw.write(outChars);
        fw.close();
    }
}

class TestCopy{
    public static void main(String[] args) throws IOException {
        // 源文件
        File srcFile = new File("F:\\test.txt");
        // 目标文件
        File destFile = new File("F:\\testCopy.txt");
        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(destFile,true);
        // 一个一个字符进行操作
/*        int n;
        while ((n = fr.read())!=-1){
            fw.write((char)n);
        }*/

        // 缓冲数组进行操作
        char[] chars = new char[10];
        int len;
        fw.write("\n");
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars, 0, len);
        }
        // 关闭流的时候，倒着关（先用的后关）
        fw.close();
        fr.close();
    }
}
