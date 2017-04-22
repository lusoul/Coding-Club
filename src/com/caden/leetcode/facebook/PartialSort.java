package com.caden.leetcode.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给 个partial sorted的数组 如1，3，5，2，4，6，8，10，20，30，11，12， 13，数组有N个数，分为M个segment，N>>>M，要求输出排序后的数组。第 反应就是merge
 k sorted list，按照那个写 下，问 问time 和space 的complexity
 merge k list(use M pointer to record the position of the begin of the sorted segment)
 */
public class PartialSort {
    public static void main(String[] args) {
        SolutionPartialSort s = new SolutionPartialSort();
        int[] A = {4,6,8,10,20,30,11,12,1,3,5,14,15};
        int[] ret = s.sort(A);
        for (int i : ret) System.out.print(i + " ");
    }
}

class SolutionPartialSort {
    class Node {
        int val;
        int idx;
        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] sort(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] ret = new int[A.length];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
           @Override
            public int compare(Node n1, Node n2) {
               return n1.val - n2.val;
           }
        });

        pq.offer(new Node(A[0], 0));
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) pq.offer(new Node(A[i], i));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            ret[idx++] = cur.val;
            if (cur.idx < A.length - 1 && cur.val < A[cur.idx + 1]) {
                pq.offer(new Node(A[cur.idx + 1], cur.idx + 1));
            }
        }
        return ret;
    }
}



