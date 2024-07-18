import java.io.*;

/**
 * 字节流实现文件复制：FileInputStream,FileOutputStream
 */
public class InputStreamCopy {
    public static void main(String[] args) {
//        File srcFile = new File("F:\\test.txt");
        File srcFile = new File("F:\\pic.png");
        FileInputStream in = null;
        try {
            in = new FileInputStream(srcFile);
            /**
             * 文件以utf-8编码进行存储，英文字符底层占用一个字节，中文字符底层占用三个字节
             * 如果文件是文本文件，建议使用字符流进行读取（将一个总问拆成三个字节，没必要）
             * read()方法读取一个字节，返回类型为int，而不是byte？
             *      read方法底层做了处理，让返回的数据都是正数，为了避免字节返回的是-1，无法断定是读入的-1还是文件结尾
             */
            // 一个字节一个字节的读取
/*            int n = in.read();
            int count = 0;
            while (n != -1) {
                count++;
                System.out.println(n);
                n = in.read();
            }
            System.out.println("字节总数：" + count);*/

            System.out.println("=========缓冲数组=============");
            byte[] bytes = new byte[1024];
            int len=in.read(bytes);
            while (len!=-1){
                for (int i = 0; i < len; i++) {
//                    System.out.println(bytes[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

// 文本文件通过字节流进行复制
class TestImageCopy {
    public static void main(String[] args) {
        File file = new File("F:\\empty.txt");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream("F:\\emptyCopy.txt");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class test{
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\pic.png");
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter("F:\\picTest.png");
        char[] chars = new char[1024];
        int len=0;
        while ((len=reader.read(chars))!=-1) {
            writer.write(chars,0,len);
        }
        writer.close();
        reader.close();

    }
}