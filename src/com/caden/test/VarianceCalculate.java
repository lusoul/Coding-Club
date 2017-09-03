package com.caden.test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lusoul on 2017/4/6.
 */
public class VarianceCalculate {
    public static void main(String[] args) {
        String s = "abDD:K  8 :. 0";
        System.out.println(s.toLowerCase());
//        int[] A = {1,2,3,4,7,8,9,11,12,14,14,15,16};
//        int[] A = {1,2,3,4,7,8};
        int[] A = {4,7,8};
        System.out.println(calculateVariance(A));
        System.out.println(findMid(A));
//        int[] B = {5,2,1,8,11,13,7,6,15,6,11,8,11};
//        int[] B = {5,2,1,8,11,13};
        int[] B = {8,11,13};
        System.out.println(calculateVariance(B));
        System.out.println(findMid(B));

    }
    public static double calculateVariance(int[] A) {
        double ave = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        ave = sum / A.length;
        double cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur += Math.pow((A[i] - ave), 2);
        }
        return cur / A.length;
    }

    public static int findMid(int[] A) {
        int start = 0, end = A.length - 1;
        int k = A.length % 2 == 0 ? A.length / 2 : A.length / 2 + 1;
        while (start < end) {
            int mid = partition(A, start, end);
            int num = mid - start + 1;
            if (num == k) {
                return A[mid];
            } else if (num < k) {
                k = k - num;
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
    public static int partition(int[] A, int start, int end) {
        int pivot = A[start];
        while (start < end) {
            while (start < end && A[end] >= pivot) {
                end--;
            }
            A[start] = A[end];
            while (start < end && A[start] <= pivot) {
                start++;
            }
            A[end] = A[start];
        }
        A[start] = pivot;
        return start;
    }

    public static int[] generateLeftArray(int[] A, int threshold) {
        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {

        }
        return ret;
    }
}
