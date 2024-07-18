package org.yy.collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class TestListIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.addAll(Arrays.asList("222","444","555"));
//        Iterator<String> iterator = list.iterator();    // list和iterator同时操作 list，报错并发操作异常
//        while (iterator.hasNext()){
//            if(iterator.next().equals("222"))
//                list.add("bbb");
//        }
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("222"))
                iterator.add("bbb");
        }
        System.out.println(list);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasPrevious()+iterator.previous());
    }
}
