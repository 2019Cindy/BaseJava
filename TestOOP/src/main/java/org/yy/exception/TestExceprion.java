package org.yy.exception;

import java.util.Scanner;

/**
 * try-catch后面代码不执行：
 *      throw抛出异常
 *      catch中没有捕获
 *      在try中遇到return
 * try-catch后面代码必须执行：
 *      将必须执行的代码放入finally中
 * return和finally的执行顺序
 *      先执行finally，在执行return
 * System.exit();可以让finally中的代码不执行
 */
public class TestExceprion {
    public static void main(String[] args) {
        // 检查异常
        try {
            Class.forName("Person").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

       try{
           Scanner scanner = new Scanner(System.in);
           System.out.println("请输入第一个数：");
           int num1 = scanner.nextInt();
           System.out.println("请输入第二个数：");
           int num2 = scanner.nextInt();
           System.out.println(num1 / num2);

           return;
       }catch (Exception e){
           throw e;
       }finally {
           System.out.println("谢谢使用。。。。");
       }


    }
}
