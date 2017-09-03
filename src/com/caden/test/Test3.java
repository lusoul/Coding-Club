package com.caden.test;

import java.util.*;

public class Test3 {
    static class Node {
        int val;
        List<Node> neighbors;
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
        public int hashCode() {
            return val;
        }
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node cur = (Node)obj;
                return cur.val == this.val;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        Integer[] arr = set.toArray(new Integer[set.size()]);
//        Map<Integer, List<Integer>> dictionary = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        list.add(2);list.add(3);list.add(5);
//        dictionary.put(1, list);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(3);list2.add(1);
//        dictionary.put(2, list2);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(2);list3.add(6);
//        dictionary.put(5, list3);
        List<Node> lists = contstructGraph();
        List<String> ret = new ArrayList<>();
        for (Node node : lists) {
        }

        for (String str : ret) System.out.println(str);
//        System.out.println(ret.size());

    }
    public static List<Node> contstructGraph() {
        List<Node> ret = new ArrayList<>();
        Node node1 = new Node(1);Node node2 = new Node(2);//Node node3 = new Node(3);
        Node node5 = new Node(5);//Node node6 = new Node(6);
        node1.neighbors.add(node2);//node1.neighbors.add(node3);
        node1.neighbors.add(node5);
        //node2.neighbors.add(node3);
        node2.neighbors.add(node1);
        node5.neighbors.add(node2);//node5.neighbors.add(node6);
        ret.add(node1);ret.add(node2);//ret.add(node3);
        ret.add(node5);//ret.add(node6);
        return ret;
    }

    public static void search(List<String> ret, String path, Node node, Set<Node> set) {
        if (set.contains(node)) {
            ret.add(path);
            return;
        }

        String temp = path + " " + node.val;
        List<Node> neighbors = node.neighbors;
        set.add(node);
        for (Node nei : neighbors) {
            search(ret, temp, nei, set);
        }
        set.remove(node);

    }
}




