/**
 * 代码块
 *  普通块：限制了局部变量的作用范围
 *  构造块：
 *  静态块：
 *  1.代码块执行顺序：最先执行静态块：只在类加载的时候执行一次，一般用于执行一些全局性的初始操作
 *      再执行构造块，再执行构造器，再执行方法中的普通块
 */
public class TestBlock {
    public void a() {
        // 普通代码块
        {
            System.out.println("=============普通块");
            int aa = 10;
            System.out.println(aa);
        }
//        System.out.println(aa);
    }

    {
        System.out.println("========构造块");
    }

    static {
        System.out.println("=========静态块");
    }

    public static void main(String[] args) {
        TestBlock block = new TestBlock();
        block.a();
    }
}
