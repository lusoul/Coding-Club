package com.caden.test;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] A = {1,2};
        System.out.println(s.maxProfit(A));

        String str = "0123";
        byte[] buf = str.getBytes();
        for (byte b : buf) {
            System.out.println(b);
        }
        System.out.println((int)'h');

    }

}

class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int col = prices.length > 4 ? 6 : prices.length + 1;
        int[][] F = new int[prices.length + 1][col];
        for (int i = prices.length; i >= 0; i--) {
            for (int j = col - 1 ; j >= 1; j--) {
                if (i == prices.length) {
                    F[i][j] = 0;
                    break;
                }
                if (j == col - 1) {
                    F[i][j] = 0;
                } else if (j == 4 || j == 2) {
                    int left = F[i + 1][j + 1];
                    int right = F[i + 1][j];
                    F[i][j] = Math.max(left + prices[i], right);
                } else if (j == 1 || j == 3) {
                    int left = F[i + 1][j + 1];
                    int right = F[i + 1][j];
                    F[i][j] = Math.max(left - prices[i], right);
                }
            }
        }
        return F[0][1];
    }
}



