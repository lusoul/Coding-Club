package com.caden.leetcode.amazon.OA;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给个matrix,其中只有一格是9，其他格子是0或1，0表示此路不通，1表示可以走，判断从（0,0) 点开始上下左右移动能否找到这个是9的格子
 *
 * 比较坑的corner case就是0，0点为9或者为0的情况
 */
public class Maze {
    public static void main(String[] args) {
        SolutionMaze s = new SolutionMaze();
        int[][] matrix = {
                {1,0,1,0,1,0},
                {1,1,1,0,1,0},
                {0,1,0,9,1,0},
                {1,1,1,0,1,0},
                {1,0,1,1,1,1}
        };
        System.out.println(s.findNine(matrix));
    }
}

class SolutionMaze {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean findNine(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        if (matrix[0][0] == 0) return false;
        if (matrix[0][0] == 9) return true;
        int row = matrix.length;
        int col = matrix[0].length;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int x = cur / col;
            int y = cur % col;
            if (matrix[x][y] == 9) return true;
            for (int i = 0; i < 4; i++) {
                int dirX = x + dir[i][0];
                int dirY = y + dir[i][1];

                if (dirX < 0 || dirX >= row || dirY < 0 || dirY >= col) continue;
                if (matrix[dirX][dirY] == 0) continue;
                queue.offer(dirX * col + dirY);
            }
            matrix[x][y] = 0;
        }
        return false;
    }
}
