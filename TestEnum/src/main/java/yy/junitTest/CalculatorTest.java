package yy.junitTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    // 某个方法中，加入了@Before注解后，这个方法就会在测试方法开始前执行
    // 一般会在before修饰的方法中加入 申请资源的代码，申请数据库资源、申请IO资源等
    @Before
    public void init(){
        System.out.println("测试开始。。。");
    }
    // 某个方法中，加入了@After注解后，这个方法就会在测试方法结束后执行
    // 一般会在after修饰的方法中加入 释放资源的代码，释放数据库资源、IO资源等
    @After
    public void end(){
        System.out.println("测试结束。。。");
    }
    @Test
    public void TestAdd(){
        System.out.println("add测试开始。。。");
        Calculator calculator = new Calculator();
        int res = calculator.add(10, 20);
        // 断言：预测一下结果，判断一下预测的结果和 实际的结果是否一致：
        // 第一个参数：预测结果  第二个参数：实际结果
        Assert.assertEquals(30,res);
    }

    @Test
    public void TestSub(){
        System.out.println("sub测试开始。。。");
        Calculator calculator = new Calculator();
        int res = calculator.sub(20, 10);
        System.out.println(res);
    }
}
