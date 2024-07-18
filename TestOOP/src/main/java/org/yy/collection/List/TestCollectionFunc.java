package org.yy.collection.List;

import java.util.*;

/**
 * Collection接口常用方法：
 * 增：add addAll
 * 删：clear remove
 * 改：
 * 查：iterator size
 * 判断：contains equals isEmpty
 */
public class TestCollectionFunc {
    public static void main(String[] args) {
        // 接口不能创建对象，得用实现类创建对象
        Collection col = new ArrayList<>();
        // 集合有个特点：只能存放引用类型的数据，不能是基本数据类型
        // 基本数据类型自动装箱，int ---> Integer
        col.add(111);
        col.add(new Integer(222));
        System.out.println("add:" + col);

        List<String> list = Arrays.asList("11", "22", "33");
        col.addAll(list);
        System.out.println("addAll:" + col);

//        col.clear();
        System.out.println("clear:" + col);
        System.out.println("size：" + col.size());
        System.out.println("isEmpty:" + col.isEmpty());

        boolean remove = col.remove(111);
        System.out.println("remove:" + remove + col);

        ArrayList<String> col2 = new ArrayList<>();
        col2.addAll(Arrays.asList("a","b","c"));
        ArrayList<String> col3 = new ArrayList<>();
        col3.addAll(Arrays.asList("a", "b", "c"));
        System.out.println("equals:" + col2.equals(col3));
        System.out.println(col2 == col3);

        System.out.println("contains:" + col3.contains("a"));

//===============集合遍历=========================
        for (Object obj : col) {
            System.out.println("增强for:" + obj);
        }

        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator:" + iterator.next());
        }
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
    }
}
