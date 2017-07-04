package com.caden.leetcode.facebook;

/**
 * 找 偷问题，有n个房间，其中 个房间有 偷。早上我们可以打开 个房间的 看 偷在 在
 * ，晚 上 偷会向左边或者右边的房间 。现在给你 个开 的sequence，你输出这个sequence能  能保证找到 偷
 *  如:如果只有三个房间那么如果打开房间的sequence是{1，1}那么 定会找到 偷。因为如 果 偷在中间那么第 天就会被找到，.
 *  如果 偷在两边那么第 天 定回来到中间也会被找到。房间数为n，sequence 度为k
 *
 *  rooms = 4; strategy[]={0,2,1,1,2} -> true
 *  rooms = 3; strategy[]={1,1} - true
 */
public class FindThief {
    public static void main(String[] args) {
        int rooms = 5;
        int[] strategy = {0,2,1,1,2,3,2,3,1,1,0,3,3,3,2};
        SolutionFindThief s = new SolutionFindThief();
        System.out.println(s.findThief(rooms, strategy));
        System.out.println(s.findThiefDP(rooms, strategy));
    }
}

class SolutionFindThief {
    int[][] cache;
    public boolean findThief(int rooms, int[] strategy) {
        cache = new int[rooms][strategy.length];
        boolean ret = true;
        for (int i = 0; i < rooms; i++) {
            ret = ret && search(i, rooms, strategy, 0);
        }
        return ret;
    }

    private boolean search(int idx, int rooms, int[] s, int pos) {
        if (pos >= s.length) return false;
        if (s[pos] == idx) return true;
        if (cache[idx][pos] != 0) return cache[idx][pos] == 1;

        boolean left = true, right = true;
        if (idx > 0) {
            left = search(idx - 1, rooms, s, pos + 1);
        }
        if (idx < rooms - 1) {
            right = search(idx + 1, rooms, s, pos + 1);
        }
        cache[idx][pos] = left && right ? 1 : -1;
        return left && right;
    }

    public boolean findThiefDP(int rooms, int[] strategy) {
        boolean[][] F = new boolean[rooms][strategy.length];
        boolean ret = true;
        for (int j = strategy.length - 1; j >= 0; j--) {//必须把j放在最外层循环，否则结果出错！！！因为它相当于行
            for (int i = 0; i < rooms; i++) {
                if (strategy[j] == i) {
                    F[i][j] = true;
                    continue;
                }
                boolean left = true, right = true;
                if (i > 0) left = j + 1 >= strategy.length ? false : F[i - 1][j + 1];
                if (i < rooms - 1) right = j + 1 >= strategy.length ? false : F[i + 1][j + 1];
                F[i][j] = left && right;
            }
        }
        for (int i = 0; i < rooms; i++) {
            ret = ret && F[i][0];
        }
        return ret;
    }
}
