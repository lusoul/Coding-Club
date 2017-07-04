package com.caden.leetcode.Teradata;

import java.util.ArrayList;
import java.util.List;

public class ThreeSmallestNum {
    public static void main(String[] args) {
        int[] A = {5,2,1,7,8,9,10,11,4,3,6,0};
        SolutionThreeSmallestNum s = new SolutionThreeSmallestNum();
        List<Integer> ret = s.count(A);
        for (Integer i : ret) System.out.print(i + " ");
    }
}

class SolutionThreeSmallestNum {
    public List<Integer> count(int[] A) {
        List<Integer> ret = new ArrayList<>();
        if (A == null || A.length <= 2) return ret;
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = partition(A, start, end);
            if (mid == 2) {
                ret.add(A[0]);
                ret.add(A[1]);
                ret.add(A[2]);
                return ret;
            } else if (mid > 2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }
    private int partition(int[] A, int start, int end) {
        int pivot = A[start];
        while (start < end) {
            while (start < end && A[end] >= pivot) {
                end--;
            }
            A[start] = A[end];
            while (start < end && A[start] <= pivot) {
                start++;
            }
            A[end] = A[start];
        }
        A[start] = pivot;
        return start;
    }
}
