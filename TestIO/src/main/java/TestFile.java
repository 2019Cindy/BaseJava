import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\test2.txt");
        // File.separator:获取当前操作系统的路径拼接符
        File f2 = new File("F:" + File.separator + "test2.txt");

        System.out.println("==========对文件进行操作============");
        // 常用方法：
        System.out.println("是否可读：" + file.canRead());
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("文件名字：" + file.getName());
        System.out.println("父目录：" + file.getParent());
        System.out.println("是否为目录：" + file.isDirectory());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("文件大小：" + file.length());
        System.out.println("是否存在：" + file.exists());
//        if(file.exists())
//            file.delete();
//        else
//            file.createNewFile();

        System.out.println(file == f2); // 比较地址
        System.out.println(file.equals(f2));    // 比较文件的路径
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("相对路径：" + file.getPath());
        System.out.println(file.toString());    // toString 输出相对路径

        System.out.println("==========对目录进行操作============");
        File f3 = new File("F:\\test\\a\\b");
        // 创建目录
        f3.mkdir(); // 创建单层目录
        f3.mkdirs();    // 创建多层目录
        // 删除目录
        f3.delete();    // 删除单层目录，并且这层目录是空的，里面没有内容，如果有内容也不会被删除
        // 查看：
        File f4 = new File("F:\\");
        String[] list = f4.list();
        for (String s : list) {
            System.out.println("list:" + s);
        }
        File[] files = f4.listFiles();
        for (File f : files) {
            System.out.println("listFiles:"+f.getName()+":"+f.length());
        }
    }
}
