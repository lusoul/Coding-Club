package com.caden.leetcode.amazon.OA;

import java.util.LinkedList;

/**
 * 实现 LRU Cache再判断啥时候miss就好了，返回miss数. 不需要写LRU，只需要用LinkedList模拟下就好，只是LinkedList的remove操作
 * 时间复杂度高点，但是无所谓了
 */
public class LRUCacheMissCount {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,2,5,3,4};
        SolutionLRUCacheMissCount s = new SolutionLRUCacheMissCount();
        System.out.println(s.countMiss(A, 3));
    }
}

class SolutionLRUCacheMissCount {
    //A[]为操作元素的key，size为LRU的大小，如果A[i]不存在于LRU中就是miss一次了嘛
    public int countMiss(int[] A, int size) {
        if (A == null || A.length == 0) return 0;
        LinkedList<Integer> cache = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!cache.contains(A[i])) {
                count++;
                if (cache.size() == size) {
                    cache.remove(0);
                }
                cache.add(A[i]);
            } else {
                cache.remove(new Integer(A[i]));//如果你直接cache.remove(A[i])就变成了remove index啦
                cache.add(A[i]);
            }
        }
        return count;
    }
}

