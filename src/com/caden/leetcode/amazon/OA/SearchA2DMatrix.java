package com.caden.leetcode.amazon.OA;

/**
 * I:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 ● Integers in each row are sorted from left to right.
 ● The first integer of each row is greater than the last integer of the previous row.
 For example,
 Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]

 Given target = 3, return true.

 II:
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 ● Integers in each row are sorted in ascending from left to right.
 ● Integers in each column are sorted in ascending from top to bottom.
 For example,
 Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]

 Given target = 5, return true.
 Given target = 20, return false.
 */
public class SearchA2DMatrix {
}

class SolutionSearchA2DMatrix {
    public boolean searchMatrixI(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0, end = row * column - 1;
        // find >= target first position
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / column][mid % column] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (matrix[start / column][start % column] == target) {
            return true;
        }
        if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }

    // 非binary search右上角点走法 复杂度(n+m)
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x <= m - 1 && y >= 0) {
            if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }
}