package com.caden.leetcode.amazon.OA;

/**
 * Created by lusoul on 2017/5/6.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        SolutionGreatestCommonDivisor s = new SolutionGreatestCommonDivisor();
        int[] A = {66,36,24,12};
        System.out.println(s.greatestCommonDivisor(A));
    }
}

class SolutionGreatestCommonDivisor {
    public int greatestCommonDivisor(int[] A) {
        int num = A[0];
        for (int i = 1; i < A.length; i++) {
            num = gcd(num, A[i]);
        }
        return num;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
