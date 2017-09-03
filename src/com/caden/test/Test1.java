package com.caden.test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        SolutionIS s = new SolutionIS();
        char[][] board = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(s.numIslands(board));
    }
}

class SolutionIS {
    public int numIslands(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int row = board.length, col = board[0].length;
        UF uf = new UF(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') continue;
                if (i + 1 < row && board[i + 1][j] == '1')
                    uf.union(i * col + j, (i + 1) * col + j);
                if (j + 1 < col && board[i][j + 1] == '1')
                    uf.union(i * col + j, i * col + j + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1' && uf.find(i * col + j) == i * col + j)
                    count++;
            }
        }
        return count;
    }
}

class UF {
    int[] id;
    int[] size;
    public UF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}