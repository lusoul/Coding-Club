package com.caden.test;

/**
 * Created by lusoul on 2017/4/29.
 */
public class EEEEE {
    public static void main(String[] args) {
        int[] A = {2,1};
        int k = 2;
        SolutionKTH s = new SolutionKTH();
        System.out.println(s.findKthLargest(A, k));
    }
}

class SolutionKTH {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = partition(nums, start, end);
            if (mid - start + 1 == k) {
                return nums[mid];
            } else if (mid - start + 1 < k) {
                k = k - (mid - start + 1);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int partition(int[] A, int start, int end) {
        int pivot = A[start];
        while (start < end) {
            while (start < end && A[end] <= pivot) {
                end--;
            }
            A[start] = A[end];
            while (start < end && A[start] >= pivot) {
                start++;
            }
            A[end] = A[start];
        }
        A[start] = pivot;
        return start;
    }

    private boolean search(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            if (i == s.length() || p.charAt(j) != '.' && s.charAt(i) != p.charAt(j)) {
                return search(s, p, i, j + 2);
            } else {
                return search(s, p, i, j + 2) || search(s, p, i + 1, j);
            }
        } else {
            if (i == s.length() || p.charAt(j) != '.' && s.charAt(i) != p.charAt(j)){
                return false;
            } else {
                return search(s, p, i + 1, j + 1);
            }
        }
    }
}



