package org.yy.collection.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkList中常用方法
 * 增：addFirst addLast offer offerFirst offerLast
 * 删：poll pollFirst pollLast removeFirst removeLast
 * 改：
 * 查：element getFirst getLast indexOf lastIndexOf peek peekFirst peekLast
 * 判断：
 */
public class TestLinkListFunc {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 添加元素
        linkedList.add(111);
        linkedList.addAll(Arrays.asList(2, 3, 4, 5, 6));
        System.out.println(linkedList);
        linkedList.addFirst(0);
        System.out.println(linkedList);
        linkedList.addLast(100000);
        System.out.println(linkedList);
        linkedList.offer(5678);
        System.out.println(linkedList);
        linkedList.offerFirst(123123);
        linkedList.offerLast(789789);
        System.out.println(linkedList);

        // 删除元素
        Integer poll = linkedList.poll();// 删除头部元素并返回删除的元素
        System.out.println(linkedList);
        linkedList.pollFirst(); // JDK1.6新出的方法，解决异常
        linkedList.pollLast();
        System.out.println(linkedList);

        linkedList.remove();
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

//        linkedList.clear();
        Integer pollFirst = linkedList.pollFirst();
        System.out.println(linkedList);
        // 报错 NoSuchElementException
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList);

        // 遍历
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("fori:" + linkedList.get(i));
        }
        for (Integer i : linkedList) {
            System.out.println("foreach:" + i);
        }
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator:" + iterator.next());
        }
    }
}
