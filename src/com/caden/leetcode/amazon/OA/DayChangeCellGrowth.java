package com.caden.leetcode.amazon.OA;

import java.util.Arrays;

/**
 * int[] dayChange(int[] cells, int days), cells 数组，有8个元素，每天的变化情况是
 * 当前位置 cell = (cell[i - 1] == cell[i + 1]) ? 0 : 1, 左右相等，当前位置为0， 不等为1，
 * 默认 cells[0]左边 和 cells[cells.length - 1]右边的位置元素都是0， 求days天后的变化.
 */
public class DayChangeCellGrowth {
    public static void main(String[] args) {
        int[] cells = {1,0,0,1,1,1,0,1};
        SolutionDayChangeCellGrowth s = new SolutionDayChangeCellGrowth();
        int[] ret = s.dayChange(cells, 1);
        for (int i : ret) System.out.print(i + " ");
    }
}

class SolutionDayChangeCellGrowth {
    public int[] dayChange(int[] cells, int day) {
        if (cells == null || cells.length < 8 || day <= 0) return cells;
        int[] ret = new int[cells.length + 2];
        for (int i = 1; i <= cells.length; i++) {
            ret[i] = cells[i - 1];
        }

        for (int i = 0; i < day; i++) {
            int prev = 0;
            for (int j = 1; j < ret.length - 1; j++) {
                int temp = ret[j];
                ret[j] = prev ^ ret[j + 1];
                prev = temp;
            }
        }
        return Arrays.copyOfRange(ret, 1, ret.length - 1);
    }
}