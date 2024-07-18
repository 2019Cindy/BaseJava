package org.yy.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 装填因子0.75的原因：
 *  如果装填因子是1， 那么数组满了再扩容，可以做到  最大的空间利用率
 *      但是这是一个理想状态，元素不可能完全的均匀分布，很可能就哈西碰撞产生链表了。产生链表的话 查询时间就长了。
 *      ---》空间好，时间不好
 *  如果是0.5的话，就浪费空间，但是可以做到 到0.5就扩容 ，然后哈西碰撞就少，
 *      不产生链表的话，那么查询效率很高
 *      ---》时间好，空间不好
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        System.out.println(hashMap.put(111, "aaa"));
        System.out.println(hashMap.put(222, "bbb"));
        System.out.println(hashMap.put(333, "ccc"));
        System.out.println(hashMap.put(111, "ttt"));    // 返回oldValue
        System.out.println(hashMap);
        System.out.println(hashMap.size());

        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("111","222","333"));
        System.out.println(list);
        System.out.println(list.size());
//        list.clear();
        System.out.println(list+":"+list.size());
    }
}
