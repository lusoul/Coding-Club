package com.caden.leetcode.amazon.OA;

/**
 * 给一个int[][]的matirx，对于一条从左上到右下的path pi，pi中的最小值是mi，求所有mi中的最大值。只能往下或右.
 比如：

 [8, 4, 7]
 [6, 5, 9]
 有3条path：
 8-4-7-9 min: 4
 8-4-5-9 min: 4
 8-6-5-9 min: 5
 return: 5
 */
public class MaximumMinimumPath {
    public static void main(String[] args) {
        int[][] matrix = {
                {8,4,7},
                {6,5,9}
        };
        SolutionMaximumMinimumPath s = new SolutionMaximumMinimumPath();
        System.out.println(s.maxMinPath(matrix));
    }
}

class SolutionMaximumMinimumPath {
    public int maxMinPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] F = new int[matrix.length][matrix[0].length];
        F[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            F[i][0] = Math.min(matrix[i][0], F[i - 1][0]);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            F[0][i] = Math.min(matrix[0][i], F[0][i - 1]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                int left = Math.min(F[i][j - 1], matrix[i][j]);
                int up = Math.min(F[i - 1][j], matrix[i][j]);
                F[i][j] = Math.max(left, up);
            }
        }
        return F[matrix.length - 1][matrix[0].length - 1];
    }
}
