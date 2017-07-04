package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//一个数组里有多个最大值，等概率随机返回其中一个最大值的index，one pass
public class ReserviorSampling {
    public static void main(String[] args) {
        int[] A = {1,1,3,5,2,5,2,2,4,5,1};
        System.out.println(sampling(A));
        List<Integer> list = new ArrayList<>();
        list.set(1, 10);
        System.out.println(list.size());
    }

    public static int sampling(int[] A) {
        Random rd = new Random();
        int max = Integer.MIN_VALUE;
        int ret = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                total = 1;
                ret = i;
            } else if (max == A[i]) {
                total++;
                int rdNum = rd.nextInt(total);
                ret = rdNum == 0 ? i : ret;
            }
        }
        return ret;
    }
}



