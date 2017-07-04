package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 一个board里面，有障碍物，若干个guard，空地上的安全距离定义为与最近的guard的距离，需要找到所有安全距离最大的空地坐标。类似leetcode542。
 一开始没想到最优解，在大叔一步一步引导下找到了最优解，用BFS, queue一次性存所有的guard的距离，再往外扩张，如果board是int型的话，就可以利用原board存距离，节省空间。
 这题就是01matrix(LC542)，把guard当作0，空地当作1，障碍物当作-1
 */
public class GuardObstacle {
    public static void main(String[] args) {
        int[][] board = {{1,1,1,1,1,1},
                {1,0,1,-1,1,1},
                {0,0,-1,0,-1,1},
                {1,0,1,0,1,1},
                {-1,1,1,1,-1,1},
                {1,1,0,1,1,1},
                {1,1,1,-1,1,1}};
        GuardObstacle go = new GuardObstacle();
        List<List<Integer>> ret = go.getBiggestSpot(board);
        for (List<Integer> list : ret) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // 0表示guard，-1表示障碍物，1表示空地
    public List<List<Integer>> getBiggestSpot(int[][] board) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Integer.MAX_VALUE;
                } else if (board[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int max = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (board[cur[0]][cur[1]] > max) {
                max = board[cur[0]][cur[1]];
                ret.clear();
                List<Integer> coordinate = new ArrayList<>();
                coordinate.add(cur[0]);
                coordinate.add(cur[1]);
                ret.add(coordinate);
            } else if (board[cur[0]][cur[1]] == max) {
                List<Integer> coordinate = new ArrayList<>();
                coordinate.add(cur[0]);
                coordinate.add(cur[1]);
                ret.add(coordinate);
            }

            for (int i = 0; i < 4; i++) {
                int dirX = cur[0] + dir[i][0];
                int dirY = cur[1] + dir[i][1];

                if (dirX < 0 || dirX >= board.length || dirY < 0 || dirY >= board[0].length) continue;
                if (board[dirX][dirY] <= board[cur[0]][cur[1]] + 1) continue;

                board[dirX][dirY] = board[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{dirX, dirY});
            }
        }
        return ret;
    }
}


