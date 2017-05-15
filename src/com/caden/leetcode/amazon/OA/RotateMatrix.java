package com.caden.leetcode.amazon.OA;

/**
 * 给一个matrix和flag，flag=1表示顺时针转90度，为0表示逆时针转90度
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15},
                {16,17,18,19},
                {20,21,22,23}};
        SolutionRotateMatrix s = new SolutionRotateMatrix();
        int[][] ret = s.rotateMatrix(matrix, 0);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class SolutionRotateMatrix {
    public int[][] rotateMatrix(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        int[][] trans = transform(matrix);//把矩阵i,j变成j,i
        return rotate(trans, flag);
    }
    private int[][] transform(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ret = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ret[i][j] = matrix[j][i];
            }
        }
        return ret;
    }
    private int[][] rotate(int[][] matrix, int flag) {
        if (flag == 1) { //clock-wise
            int col = matrix[0].length;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < col / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][col - j - 1];
                    matrix[i][col - j - 1] = temp;
                }
            }
        } else { //逆时针
            int row = matrix.length;
            for (int i = 0; i < row / 2; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[row - i - 1][j];
                    matrix[row - i - 1][j] = temp;
                }
            }
        }
        return matrix;
    }
}
