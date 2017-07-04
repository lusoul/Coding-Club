package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 二维平面上一堆坐标点， 求离原点最近的K个点
 */
public class KNearestPoint {
    public static void main(String[] args) {
        KNearestPoint knp = new KNearestPoint();
        Node n1 = new Node(1,1);Node n2 = new Node(1,-1);Node n3 = new Node(3,4);Node n4 = new Node(3,3);Node n5 = new Node(-1,-1);
        Node n6 = new Node(-1,-2);Node n7 = new Node(4,5);Node n8 = new Node(3,6);Node n9 = new Node(2,2);Node n10 = new Node(-1,2);
        Node n11 = new Node(-2,1);Node n12 = new Node(-3,5);Node n13 = new Node(0,1);Node n14 = new Node(-1,0);Node n15 = new Node(6,6);
        Node n16 = new Node(-6,0);Node n17 = new Node(0,-3);Node n18 = new Node(-3,1);Node n19 = new Node(9,9);Node n20 = new Node(4,-1);
        Node n21 = new Node(9,1);Node n22 = new Node(0,-7);Node n23 = new Node(-2,-2);Node n24 = new Node(-2,9);Node n25 = new Node(4,8);
        List<Node> list = new ArrayList<>();
        list.add(n25);list.add(n24);list.add(n23);list.add(n22);list.add(n21);list.add(n20);list.add(n19);list.add(n18);
        list.add(n17);list.add(n16);list.add(n15);list.add(n14);list.add(n13);list.add(n12);list.add(n11);list.add(n10);
        list.add(n9);list.add(n8);list.add(n7);list.add(n6);list.add(n5);list.add(n4);list.add(n3);list.add(n2);list.add(n1);

        List<Node> ret = knp.getNearest(list, new Node(0, 0), 6);
        for (Node node : ret) {
            System.out.println(node.x + " " + node.y);
        }
    }

    public List<Node> getNearest(List<Node> list, Node root, int k) {
        List<Node> ret = new ArrayList<>();
        if (list == null || list.size() == 0 || root == null) {
            return ret;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int d1 = Math.abs(o1.x) + Math.abs(o1.y);
                int d2 = Math.abs(o2.x) + Math.abs(o2.y);
                return d2 - d1;
            }
        });
        for (Node node : list) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.offer(node);
            } else {
                Node peek = pq.peek();
                int max = Math.abs(peek.x) + Math.abs(peek.y);
                int cur = Math.abs(node.x) + Math.abs(node.y);
                if (cur < max) {
                    pq.poll();
                    pq.offer(node);
                }
            }
        }
        while (!pq.isEmpty()) {
            ret.add(pq.poll());
        }
        return ret;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
