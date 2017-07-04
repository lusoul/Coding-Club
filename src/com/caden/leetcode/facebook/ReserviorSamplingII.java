package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给l*w的矩阵，要随机取k个点
 *
 * 这题不需要用水池抽样，直接用洗牌法就可以解, 二维转一纬，每次取到一个值以后记录并和起点位置进行交换，进入下一次循环
 */
public class ReserviorSamplingII {
    public static void main(String[] args) {
        SolutionReserviorSampling s = new SolutionReserviorSampling();
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        List<Integer> ret = s.randomPick(matrix, 3);
        for (Integer i : ret) System.out.print(i + " ");
    }
}

class SolutionReserviorSampling {
    public List<Integer> randomPick(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int total = row * col;
        List<Integer> ret = new ArrayList<>();
        Random rd = new Random();
        for (int start = 0; start < k; start++) {
            int rdIdx = rd.nextInt(total - start) + start;
            ret.add(matrix[rdIdx / col][rdIdx % col]);
            swap(matrix, rdIdx, start);
        }
        return ret;
    }
    private void swap(int[][] A, int i, int j) {
        int col = A[0].length;
        int temp = A[i / col][i % col];
        A[i / col][i % col] = A[j / col][j % col];
        A[j / col][j % col] = temp;
    }
}
