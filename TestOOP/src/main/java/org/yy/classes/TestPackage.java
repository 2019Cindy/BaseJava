package org.yy.classes;

/**
 * 包装类：
 * 基本数据类型       对应的包装类
 * byte             Byte
 * short            Short
 * int              Integer
 * double           Double
 * float            Float
 * long             Long
 * char             Character
 * boolean          Boolean
 *
 * 自动装箱和自动拆箱：将基本数据类型和包装类进行快速的类型转换
 *
 */
public class TestPackage {
    public static void main(String[] args) {
        // 构造器
        Integer i1 = new Integer(12);
        System.out.println(i1);
        Integer i2 = new Integer("122");
        System.out.println(i2);
//        Integer i3 = new Integer("aa");

        // 自动装箱和拆箱
        // int ---->Integer
        Integer i = 12;
        System.out.println("装箱===" + i);
        // Integer ---> int
        Integer i3 = new Integer(12);
        int num = i3;
        System.out.println("拆箱===" + i3);


        // 常用方法：
        // 1.compareTo:只返回三个值 -1 0 1
        Integer i11 = new Integer(11);
        Integer i111 = new Integer(11);
        System.out.println(i11.compareTo(i111));

        //2.equals:Integer 对equals方法进行了重写，比较的是value的值
        System.out.println(i11.equals(i111));
        System.out.println(i11 == i111);

        //3.Integer对象通过自动装箱完成
        // 如果自动装箱的值在-128 至 127 之间，那么比较的就是具体的值，否则比较的就是对象的地址
        Integer i5 = 13;
        Integer i6 = 13;
        Integer i7 = 130;
        Integer i8 = 130;
        System.out.println(i5 == i6);   // true
        System.out.println(i7 == i8);   // false

        // parseInt: String ---> int
        System.out.println(Integer.parseInt("12"));
        // toString: Integer ---> String
        System.out.println(i5.toString());
    }

}
