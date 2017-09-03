package com.caden.test;

import java.util.ArrayList;

/**
 */
public class BSSS {
    public static void main(String[] args) {
        int[] A = {1,4,4,4,5};
        int target = 5;
        int pos = binarySearch(A, target);
        System.out.println(pos + 1);
        System.out.println(pos);
    }

    private static int binarySearch(int[] A, int target) {
        // find <= target last pos
        int start = 0, end = A.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {//因为题目是找<=,所以这里判断条件也是<=
                start = mid; //因为找last pos，所以无脑移动start，last pos总会存在
            } else {
                end = mid;
            }
        }
        //因为找last pos，所以先比较end
        if (A[end] <= target) return end; //返回的条件也是<=target
        if (A[start] <= target) return start;//返回的条件也是<=target
        return -1;
    }
}


