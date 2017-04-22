package com.caden.leetcode.facebook;

/**
 * Created by lusoul on 2017/4/8.
 */
public class FindTheDuplicates {
    public static void main(String[] args) {
        int[] A = {2,3,2,1,4,5,7,6,8};
        System.out.println(findDuplicate(A));
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length - 1;
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int countStart = 0, countEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                countStart++;
            }
            if (nums[i] == end) {
                countEnd++;
            }
        }

        if (countStart > 1) return start;
        return end;
    }
}




