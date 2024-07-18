package org.yy.exception;

import java.util.Scanner;

/**
 * throw 和 throws的区别：
 * 1.位置不同：
 *      throw：方法内
 *      throws：方法声明处
 * 2.内容不同：
 *      throw+方法异常，检查异常，运行时异常
 *      throws+异常类型，可以多个类型，用，拼接
 * 3.作用不同：
 *      throw：异常出现的源头
 *      throws：在方法的声明处，告诉调用者这个方法中可能会出现声明的这些异常，然后调用者对这个异常进行处理或者继续向外抛出
 */
public class TestThrow {
    public static void main(String[] args) throws Exception {
        devide();
    }

    public static void devide() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数：");
        int num2 = sc.nextInt();
        if(num2==0){
//            throw new RuntimeException();
            throw new Exception();
        }else
            System.out.println(num1 / num2);
    }
}
