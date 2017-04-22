package com.caden.leetcode.facebook;

/**
 * Created by lusoul on 2017/4/12.
 */
public class WordSearch {
    public static void main(String[] args) {
        SolutionHive s = new SolutionHive();
        char[][] board = {{'a', 'b', 'c', 'e'},
            {'s', 'f', 'c', 's'},
            {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        System.out.println(s.exist(board, word));
    }
}

class SolutionHive {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String s, int idx, boolean[][] visited) {
        if (idx == s.length() - 1) {
            return s.charAt(idx) == board[i][j];
        }
        if (s.charAt(idx) != board[i][j]) return false;

        boolean ret = false;
        visited[i][j] = true;
        for (int k = 0; k < 4; i++) {
            int dirX = i + dir[k][0];
            int dirY = j + dir[k][1];
            if (dirX < 0 || dirX >= board.length || dirY < 0 || dirY >= board[0].length) continue;
            if (visited[dirX][dirY]) continue;
            ret |= search(board, dirX, dirY, s, idx + 1, visited);
        }
        visited[i][j] = false;
        return ret;
    }
}


