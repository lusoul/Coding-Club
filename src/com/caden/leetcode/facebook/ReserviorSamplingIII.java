package com.caden.leetcode.facebook;

import java.util.Random;

/**
 * n个数中随机取k个数的水池抽样，需要保证背包中的每一个数，出现的概率是k/n
 * 比如k=3，先把前3个数放入背包中，这三个数的概率是3/3 = 1;
 * 第4个数进来，随机数从0，1，2，3中选一个，
 * (1)如果选到0，1，2的话就说明我们选中了第4个数，此时概率是3/4，然后我们需要将这第四个数和背包中的一个数进行
 * 交换，所以我们随机rd.next(pack.size())取一个数和第四个数交换，此时背包中没被选中的2个数留下的概率是2/3,所以3/4 * 2/3 = 2/4.
 * (2)如果选到3的话，说明我们没选中第4个数，概率是1/4，此时背包中的数不变
 * 所以此时背包中的数概率是2/4 + 1/4 = 3/4 = k/n
 *
 * 关键点就是你要保证新进来的那个数被选中的概率是k/n
 */
public class ReserviorSamplingIII {
    public static void main(String[] args) {
        int[] pack = nkSampling(10, 3);
        for (int i : pack) System.out.print(i + " ");
    }
    public static int[] nkSampling(int n, int k) {
        int[] pack = new int[k];
        for (int i = 0; i < k; i++) {
            pack[i] = i;
        }
        Random rd = new Random();
        for (int i = k; i < n; i++) {
            int rdNum = rd.nextInt(i + 1);
            if (rdNum < k) {
                int pick = i;
                int rdIdx = rd.nextInt(k);
                pack[rdIdx] = pick;
            }
        }
        return pack;
    }

    //现在随机从L*W的矩阵中选K个数
    public static int[] matrixSampling(int[][] matrix, int k) {
        int[] pack = new int[k];
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        for (int i = 0; i < k; i++) {
            pack[i] = matrix[i / col][i % col];
        }
        Random rd = new Random();
        for (int i = k; i < total; i++) {
            int rdNum = rd.nextInt(i + 1);
            if (rdNum < k) {
                int pickIdx = i;
                int rdIdx = rd.nextInt(k);
                pack[rdIdx] = matrix[pickIdx / col][pickIdx % col];
            }
        }
        return pack;
    }
}


