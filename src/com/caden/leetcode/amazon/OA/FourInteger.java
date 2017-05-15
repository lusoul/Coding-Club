package com.caden.leetcode.amazon.OA;

import java.util.Arrays;

/**
 * Given four integers, make F(S) = abs(S[0]-S[1])+abs(S[1]-S[2])+abs(S[2]-S[3]) to be largest
 *
 * 四个数，排序一下，然后看公式发现规律，要想得到最大值，那么四个数中的最大值要参与运算2次，最小值也要参与运算2次。
 比如输入为 8, -4, 9, 3，排序后就是-4, 3, 8, 9那么9和-4都要参与运算2次，根据公式，S[1]和S[2]是参与运算2次的，
 所以把最小值放在S[1]位置，最大值放在S[2]位置，那么S[0]和S[3]位置放什么？因为最小值放在了S[1]位置了，
 所以倒数第二大的数要放在S[0]位置，倒数第二小的数放在S[3]位置就可以求出最大值
 */
public class FourInteger {
    public static void main(String[] args) {
        SolutionFourInteger s = new SolutionFourInteger();
        int[] ret = s.fourInteger(8, -4, 9, 3);
        for (int i : ret) System.out.print(i + " ");
    }
}

class SolutionFourInteger {
    public int[] fourInteger(int A, int B, int C, int D) {
        int[] ret = new int[4];
        ret[0] = A;
        ret[1] = B;
        ret[2] = C;
        ret[3] = D;
        Arrays.sort(ret);
        swap(ret, 0, 1);
        swap(ret, 3, 2);
        swap(ret, 0, 3);
        return ret;
    }
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
