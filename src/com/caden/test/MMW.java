package com.caden.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusoul on 2017/4/9.
 */
public class MMW {
    public static void main(String[] args) {
        SolutionQm s = new SolutionQm();
        int[][] board = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        List<Integer> list = s.spiralOrder(board);
        for (Integer i : list) System.out.print(i + " ");
    }
}

class SolutionQm {
    int downStep = 0, leftStep = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int startX = 0, startY = 0, endX = matrix.length - 1, endY = matrix[0].length - 1;
        boolean[] dir = new boolean[4];
        //dir[0]:right, dir[1]:down, dir[2]:left, dir[3]:up
        while (endX >= startX && endY >= startY) {
            dfs(startX, startY, endX, endY, matrix, dir, ret, startX, startY);
            startX++;
            startY++;
            endX--;
            endY--;
            downStep = 0;
            leftStep = 0;
            dir = new boolean[4];
        }
        return ret;
    }

    private void dfs(int startX, int startY, int endX, int endY, int[][] matrix, boolean[] dir,
                     List<Integer> ret, int x, int y) {
        if (dir[0] && x == startX) {
            dir[3] = true;
            return;
        }
        if (y < startY) {
            dir[2] = true;
            return;
        }
        if (x == endX + 1) {
            dir[1] = true;
            return;
        }
        if (y == endY + 1) {
            dir[0] = true;
            return;
        }

        ret.add(matrix[x][y]);
        if (!dir[0]) {//go right
            dfs(startX, startY, endX, endY, matrix, dir, ret, x, y + 1);
        }
        if (!dir[1]) {//go down
            downStep++;
            dfs(startX, startY, endX, endY, matrix, dir, ret, x + 1, y);

        }
        if (!dir[2] && downStep > 1) {//go left
            leftStep++;
            dfs(startX, startY, endX, endY, matrix, dir, ret, x, y - 1);

        }
        if (!dir[3] && leftStep > 1) {//go up
            dfs(startX, startY, endX, endY, matrix, dir, ret, x - 1, y);
        }
    }
}


