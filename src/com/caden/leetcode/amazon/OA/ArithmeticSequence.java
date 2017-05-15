package com.caden.leetcode.amazon.OA;

/**
 * 具体分析看有道云笔记的Arithmetic Slices
 */
public class ArithmeticSequence {
    public static void main(String[] args) {
        int[] A = {0,1,2,3,2,1,4,5,6,7,1,3,4,5,6,-1,2,5,8,8,8,8,8,7,6,5,4,3};
        SolutionArithmeticSequence s = new SolutionArithmeticSequence();
        System.out.println(s.getLAS(A));
    }
}

class SolutionArithmeticSequence {
    public int getLAS(int[] A) {
        if (A == null || A.length < 3) return 0;
        int cur = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}