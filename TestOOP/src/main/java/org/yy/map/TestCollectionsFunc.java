package org.yy.map;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections工具类
 *
 */
public class TestCollectionsFunc {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("bbb");
        list.add("aaa");
        Collections.addAll(list,  "ee","ccc");
        Collections.addAll(list, new String[]{"111", "222"});
        System.out.println("addAll:" + list);

        // binarySearch:必须在有序的集合中进行查找
        Collections.sort(list);
        System.out.println("sort:"+list);
        System.out.println(Collections.binarySearch(list, "ccc"));
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hhh");
        list2.add("ppp");
        Collections.addAll(list2,"ooo");
        Collections.copy(list, list2);  // 将list2的内容替换到list上面
        System.out.println(list);

        // fill:填充
        Collections.fill(list2,"yy");
        System.out.println("fill:"+list2);
    }
}
