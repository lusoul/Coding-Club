package com.caden.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lusoul on 2017/3/29.
 */
public class Test7 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(3, 2));

        int[] id = {0};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;

        System.out.println(id[0]);
        System.out.println(map.size());
        System.out.println(node.val);
        change(id, map, node);
        System.out.println("-----------");
        System.out.println(id[0]);
        System.out.println(map.size());
        System.out.println(node.val);
    }

    public static void change(int[] id, Map<Integer, Integer> map, ListNode node) {
        id[0]++;
        map.put(2, 2);
//        node.val = 2;
        node = node.next;

    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}


