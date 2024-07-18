package org.yy.collection.List;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * List接口中常用方法：
 *  增：add set
 *  删：remove
 *  改：
 *  查：get
 */
public class TestListFunc {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.addAll(Arrays.asList(10,20,30));
        System.out.println(list);
        list.add(3,10000);
        System.out.println(list);
        list.set(4,40000);
        System.out.println(list);
        list.remove(2); //
        System.out.println(list);

        System.out.println(list.get(1));

//=============list集合遍历========================
        for (int i = 0; i < list.size(); i++) {
            System.out.println("for:" + list.get(i));
        }

        for (Integer i : list) {
            System.out.println("foreach:" + i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator:" + iterator.next());
        }
    }
}
