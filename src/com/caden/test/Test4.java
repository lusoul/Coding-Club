package com.caden.test;

import java.util.Deque;
import java.util.LinkedList;

public class Test4 {
    public static void main(String[] args) {
        int[] A = {1,2,1,1};
        Solution6 s = new Solution6();
        System.out.println(s.rob(A));
    }
}

class Solution6 {
    int[] cache;
    public int rob(int[] A) {
        if (A == null || A.length == 0) return 0;
        cache = new int[A.length];
        int retSelectHead = searchSelectHead(A, 2);
        cache = new int[A.length];
        int retNotSelectHead = searchNotSelectHead(A, 1);
        return Math.max(retSelectHead + A[0], retNotSelectHead);
    }
    private int searchSelectHead(int[] A, int idx) {
        if (idx >= A.length - 1) return 0;
        if (cache[idx] != 0) return cache[idx] == -1 ? 0 : cache[idx];
        int left = searchSelectHead(A, idx + 2);
        int right = searchSelectHead(A, idx + 1);
        int ret = Math.max(left + A[idx], right);
        cache[idx] = ret == 0 ? -1 : ret;
        return ret;
    }
    private int searchNotSelectHead(int[] A, int idx) {
        if (idx > A.length - 1) return 0;
        if (cache[idx] != 0) return cache[idx] == -1 ? 0 : cache[idx];
        int left = searchSelectHead(A, idx + 2);
        int right = searchSelectHead(A, idx + 1);
        int ret = Math.max(left + A[idx], right);
        cache[idx] = ret == 0 ? -1 : ret;
        return ret;
    }
}

