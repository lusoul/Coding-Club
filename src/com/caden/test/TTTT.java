package com.caden.test;

/**
 * Created by lusoul on 2017/4/13.
 */
public class TTTT {
    public static void main(String[] args) {
        int[] A = {1, 7, 10, 13, 14, 19};
        int[][] F = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                F[i][j] = 2;
            }
        }

        for (int i = 0; i < A.length; i++) {
            int start = i - 1, end = i + 1, count = 1;
            while (start >= 0 && end < A.length) {
                if (A[start] + A[end] < 2 * A[i]) {
                    end++;
                } else if (A[start] + A[end] > 2 * A[i]) {
                    start--;
                } else {
                    F[start][end] = F[start][i] + count;
                    count += 2;
                    start--;
                    end++;
                }
            }
        }
        System.out.println(F[0][A.length - 1]);
    }
}
