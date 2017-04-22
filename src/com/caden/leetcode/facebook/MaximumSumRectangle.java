package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lusoul on 2017/4/21.
 */
public class MaximumSumRectangle {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);set.add(2);set.add(3);set.add(5);set.add(8);
        System.out.println(set.ceiling(4));

        int[][] board = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        int[][] matrix = {{2,1,-3,-4,5},
                {0,6,3,4,1},
                {2,-2,-1,4,-5},
                {-3,3,1,0,3}};
        int[] A = {-2,2};
        SolutionMaximumSumRectangle s = new SolutionMaximumSumRectangle();
        System.out.println(s.maxSumSubarray(A, 1));
        System.out.println(s.maxSum(board));
    }
}

class SolutionMaximumSumRectangle {
    public int maxSum(int[][] matrix) {
        int ret = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] A = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {
                for (int row = 0; row < matrix.length; row++) {
                    A[row] += matrix[row][right];
                }
                int max = maxSumSubarray(A, 1);
                ret = Math.max(max, ret);
            }
        }
        return ret;
    }

    public int maxSumSubarray(int[] A, int k) {
        int min = 0, max = Integer.MIN_VALUE, sum = 0;
        int ret = Integer.MIN_VALUE;
        List<Integer> minList = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        minList.add(min);
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            if (sum - min > k) {

            }
            max = Math.max(max, sum - min);
//            min = Math.min(min, sum);
            if (sum < min) {
                min = sum;
                minList.add(min);
            }
        }
        return max;
    }
    public int findLessThanLastPos(List<Integer> list, int target) {
        // find <= target last pos
        return 0;
    }
}
