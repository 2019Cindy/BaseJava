package org.yy.collection.set;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * TreeSet特点：底层为二叉树
 *  唯一，有序（按照顺序进行遍历）
 *  唯一，无序（没有按照输入的顺序遍历）
 */
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(90,56,78,12,34));
        System.out.println(treeSet);
    }
}
