package com.caden.leetcode.facebook;

import java.util.Random;

/**
 * 给1个数组和1个数N， 随机返回该数组中任意1个大于N的数
 */
public class ReserviorSamplingIV {
    public static void main(String[] args) {
        int[] A = {3,5,8,4,7,10,9,2,21,44,4,2,1,13};
        int target = 8;
        Random rd = new Random();
        int total = 0;
        int ret = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= target) continue;
            total++;
            int rdNum = rd.nextInt(total);
            ret = rdNum == 0 ? A[i] : ret;
        }
        System.out.println(ret);
    }
}
