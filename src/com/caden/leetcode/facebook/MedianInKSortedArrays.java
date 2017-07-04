package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianInKSortedArrays {
    public static void main(String[] args) {
        MedianInKSortedArrays s = new MedianInKSortedArrays();
        List<Integer> l1 = new ArrayList<>();l1.add(1);l1.add(3);l1.add(6);l1.add(7);l1.add(9);
        List<Integer> l2 = new ArrayList<>();l2.add(2);l2.add(4);l2.add(8);
        List<Integer> l3 = new ArrayList<>();l3.add(5);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);list.add(l2);list.add(l3);
        System.out.println(s.findMedian(list));
    }

    class Node {
        int val;
        int whichList;
        int idx;
        public Node(int val, int whichList, int idx) {
            this.val = val;
            this.whichList = whichList;
            this.idx = idx;
        }
    }

    public double findMedian(List<List<Integer>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });

        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = new Node(list.get(i).get(0), i, 0);
            pq.offer(node);
            total += list.get(i).size();
        }
        int targetFirst = 0, targetSecond = 0;
        if (total % 2 != 0) {
            targetFirst = total / 2 + 1;
            targetSecond = total / 2 + 1;
        } else {
            targetFirst = total / 2;
            targetSecond = total / 2 + 1;
        }
        int count = 0;
        double ret1 = Double.MIN_VALUE, ret2 = Double.MIN_VALUE;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            count++;
            if (count == targetFirst) ret1 = cur.val;
            if (count == targetSecond) ret2 = cur.val;
            if (targetFirst == targetSecond && targetFirst == count) break;
            if (targetFirst != targetFirst && ret1 != Integer.MIN_VALUE && ret2 != Integer.MIN_VALUE) break;

            int idx = cur.idx + 1;
            if (idx >= list.get(cur.whichList).size()) {
                continue;
            }
            Node node = new Node(list.get(cur.whichList).get(idx), cur.whichList, idx);
            pq.offer(node);
        }
        return (ret1 + ret2) / 2;
    }

}



