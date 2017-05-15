package com.caden.leetcode.Teradata;

public class SegmentTree {
    public static void main(String[] args) {
        String s = "0011";
        System.out.println(decode(s));
//        int[][] matrix = {{0, 1}};
//        setZeroes(matrix);
        int i = 0;
    }

    public static void helper(String s) {

    }
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) dfs(matrix, i, j);
            }
        }
    }
    private static void dfs(int[][] matrix, int x, int y) {
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0) return;
        matrix[x][y] = 0;
        dfs(matrix, x - 1, y);
        dfs(matrix, x, y - 1);
        dfs(matrix, x + 1, y);
        dfs(matrix, x, y + 1);
    }
    private static int decode(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret = ret * 2 + s.charAt(i) - '0';
        }
        return ret;
    }
}




