package com.caden.leetcode.facebook;

/**
 * 矩阵中,求变成为m的正方形覆盖范围最大值不超过k的值。
 *
 */
public class MatrixMSquareK {
    public static void main(String[] args) {
        SolutionMatrixMSquareK s = new SolutionMatrixMSquareK();
        int[][] matrix = {{2,1,6,4,2},
                {1,1,1,1,2},
                {3,2,5,5,1},
                {6,8,1,2,5},
                {3,2,1,2,9}};
        int m = 3, k = 25;
        System.out.println(s.sum(matrix, m, k));
    }
}
class SolutionMatrixMSquareK {
    public int sum(int[][] matrix, int m, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = matrix[i][j] + (i - 1 < 0 ? 0 : sum[i - 1][j])
                        + (j - 1 < 0 ? 0 : sum[i][j - 1]) - (i - 1 < 0 || j - 1 < 0 ? 0 : sum[i - 1][j - 1]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = m - 1; i < row; i++) {
            for (int j = m - 1; j < col; j++) {
                int ret = sum[i][j] - (i - m < 0 ? 0 : sum[i - m][j])
                        - (j - m < 0 ? 0 : sum[i][j - m])
                        + (i - m < 0 || j - m < 0 ? 0 : sum[i - m][j - m]);
                if (ret < k) {
                    max = Math.max(max, ret);
                }
            }
        }
        return max;
    }
}
