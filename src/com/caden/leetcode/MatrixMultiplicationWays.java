package com.caden.leetcode;

/**
 * 4 matrices: A  B  C  D
 Sizes: 50x10, 10x40, 40x30, 30x5
 ( ( ( A B ) C ) D )   : 87500 multiplications
 ( ( A ( B C ) ) D )   : 34500 multiplications
 ( ( A B ) ( C D ) )   : 36000 multiplications
 ( A ( ( B C ) D ) )   : 16000 multiplications
 ( A ( B ( C D ) ) )   : 10500 multiplications

 n = 1, 2, 3, 4, 5, 6, 7,  8,  9,   10
 r = 1, 1, 2, 5, 14,42,132,429,1430,4862
 */
public class MatrixMultiplicationWays {
    public static void main(String[] args) {
        SolutionMatrix s = new SolutionMatrix();
        System.out.println(s.howManyWays(10));
        System.out.println(s.howManyWaysDP(10));
    }
}

class SolutionMatrix {
    int[][] cache;
    public int howManyWays(int n) {
        cache = new int[n][n];
        return search(0, n - 1);
    }
    private int search(int start, int end) {
        if (start == end || start + 1 == end) return 1;
        if (start + 2 == end) return 2;
        if (cache[start][end] != 0) return cache[start][end];
        int sum = 0;
        for (int i = start; i < end; i++) {
            int left = search(start, i);
            int right = search(i + 1, end);
            sum += left * right;
        }
        cache[start][end] = sum;
        return sum;
    }

    public int howManyWaysDP(int n) {
        int[][] F = new int[n][n];
        // F[s][e] -> F[s][k] & F[k+1][e];
        // i->end, j->start
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {//不能j=0,j<=i,j++. 比如F[0][3]->F[0][0],F[1][3]此时F[1][3]还未计算得到是0
                if (i == j || j + 1 == i) {
                    F[j][i] = 1;
                    continue;
                }
                if (j + 2 == i) {
                    F[j][i] = 2;
                    continue;
                }
                int sum = 0;
                for (int k = j; k < i; k++) {
                    sum += F[j][k] * F[k + 1][i];
                }
                F[j][i] = sum;
            }
        }
        return F[0][n - 1];
    }
}



