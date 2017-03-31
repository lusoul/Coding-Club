package com.caden.leetcode.facebook;

/**
 * 给一个matrix, all elements are positive，问有没有个sub rectangle加起来和等于target。return true/false
 */
public class TwoDMatrixRectangleSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,2,5,4},
                {3,2,9,2},
                {1,1,5,3},
                {4,4,6,7}};
        int target = 17;
        System.out.println(s.hasRectangle(matrix, target));
    }

    static class Solution {
        public boolean hasRectangle(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int[][] sum = createSum(matrix);
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (has(i, j, sum, target, matrix)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private int[][] createSum(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] sum = new int[row][col];
            int curSum = 0;
            for (int i = 0; i < col; i++) {
                curSum += matrix[0][i];
                sum[0][i] = curSum;
            }
            curSum = 0;
            for (int i = 0; i < row; i++) {
                curSum += matrix[i][0];
                sum[i][0] = curSum;
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
            return sum;
        }

        private boolean has(int i, int j, int[][] sum, int target, int[][] matrix) {
            boolean up = false, left = false, leftAll = false, upAll = false, leftUpAll = false, all = false, self = false;
            if (i - 1 >= 0) {
                if (sum[i - 1][j] == target) upAll = true;
            }
            if (j - 1 >= 0) {
                if (sum[i][j - 1] == target) leftAll = true;
            }

            if (i - 1 >= 0 && j - 1 >= 0) {
                if (sum[i - 1][j] - sum[i - 1][j - 1] == target) up = true;
                if (sum[i][j - 1] - sum[i - 1][j - 1] == target) left = true;
                if (sum[i - 1][j - 1] == target) leftUpAll = true;
            }
            if (sum[i][j] == target) all = true;
            if (matrix[i][j] == target) self = true;
            return up || left || leftAll || upAll || leftUpAll || all || self;
        }
    }
}

