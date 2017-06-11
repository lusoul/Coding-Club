package com.caden.leetcode.amazon;

import com.caden.leetcode.ArrayToBalancedBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class WeiqiCapture {
    public static void main(String[] args) {
        //0表示空，1表示白子，-1表示黑子
        int[][] board = {
                {0,0,1,-1,1,0},
                {0,0,1,-1,1,1},
                {0,1,-1,1,0,0},
                {1,0,1,0,-1,0},
                {-1,1,0,0,0,0}};
        System.out.println(capture(board, 2, 2, -1));
    }

    public static boolean capture(int[][] board, int x, int y, int stone) {
        if (board[x][y] != stone) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        return search(board, x, y, visited);
    }
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static boolean search(int[][] board, int x, int y, boolean[][] visited) {
        boolean ret = true;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dirX = x + dir[i][0];
            int dirY = y + dir[i][1];
            if (dirX < 0 || dirY < 0 || dirX >= board.length || dirY >= board[0].length) continue;
            if (visited[dirX][dirY]) continue;
            if (board[dirX][dirY] == 1) continue;
            if (board[dirX][dirY] == 0) return false;
            ret = ret && search(board, dirX, dirY, visited);
        }
        visited[x][y] = false;
        return ret;
    }
}
