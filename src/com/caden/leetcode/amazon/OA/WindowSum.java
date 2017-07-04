package com.caden.leetcode.amazon.OA;

/**
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

 Have you met this question in a real interview? Yes
 Example
 For array [1,2,7,8,5], moving window size k = 3.
 1 + 2 + 7 = 10
 2 + 7 + 8 = 17
 7 + 8 + 5 = 20
 return [10,17,20]
 */
public class WindowSum {
    public static void main(String[] args) {
    }
}

class SolutionWindowSum {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ret = nums.length < k ? new int[1] : new int[nums.length - k + 1];
        int sum = 0, idx = 0;
        for (int i = 0; i < k && i < nums.length; i++) {
            sum += nums[i];
        }
        ret[idx++] = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            ret[idx++] = sum;
        }
        return ret;
    }
}

