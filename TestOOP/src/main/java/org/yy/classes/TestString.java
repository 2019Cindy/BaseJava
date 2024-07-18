package org.yy.classes;

/**
 * 字符串的分类：
 *  不可变字符串：String，不可变是指在地址不变的情况下，把”abc“变成”abcdef“是不可能的
 *   可变字符串：StringBuilder、StringBuffer，可变指的是在地址不变的情况下，把”abc“变成”abcdef“是可能的，直接追加即可
 *
 * String、StringBuilder、StringBuffer的区别
 *  1.String是不可变类，即一个String对象被创建后，包含在这个对象中的字符序列是不可改变的，直至整个对象被销毁
 *  2.StringBuffer类是一个字符序列可变的字符串，可以通过append、insert、reverse、setChartAt等方法改变其内容，生成了最终的字符串调用toString方法将其转变为String
 *  3.StringBuilder 效率高，线程不安全
 *  4.StringBuffer  效率低，线程安全
 */
public class TestString {
    public static void main(String[] args) {
        // 调用无参构造器，实际上底层是对value数组进行初始化，长度为16
        StringBuilder sb = new StringBuilder();
        // 调用有参构造器，传入int类型的数，实际上底层是对value数组进行初始化，长度为传入的值
        StringBuilder sb2 = new StringBuilder(10);

        StringBuilder s3 = new StringBuilder("abc");
    }
}
