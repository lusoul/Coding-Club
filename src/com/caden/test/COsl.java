package com.caden.test;

/**
 * Created by lusoul on 2017/4/7.
 */
public class COsl {
    public static void main(String[] args) {
        int[] A = {1,4,5,2,3};
        System.out.println(search(true, A, 0, A.length - 1));

        int[][] F = new int[A.length][A.length];
        boolean first = true;
        for (int i = 0; i < A.length; i++) {
            F[i][i] = A[i];
        }

        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 1; j < A.length; j++) {
                if (first) {
                    F[i][j] = Math.max(A[i] + F[i + 1][j], A[j] + F[i][j - 1]);
                    first = false;
                } else {
                    F[i][j] = Math.min(F[i + 1][j], F[i][j - 1]);
                    first = true;
                }
            }
        }
        System.out.println(F[0][A.length - 1]);
        System.out.println(F[A.length - 1][0]);
        System.out.println(F[0][0]);
        System.out.println(F[A.length - 1][A.length - 1]);
    }

    private static int search(boolean me, int[] A, int start, int end) {
        if (start == end) return A[start];

        int ret = 0;
        if (me) {
            int left = search(false, A, start + 1, end);
            int right = search(false, A, start, end - 1);
            ret = Math.max(A[start] + left, A[end] + right);
        } else {
            int left = search(true, A, start + 1, end);
            int right = search(true, A, start, end - 1);
            ret = Math.min(left, right);
        }
        return ret;
    }
}
