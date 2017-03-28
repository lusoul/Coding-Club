package com.caden.leetcode.facebook;

public class TasksToWorker {
    public static void main(String[] args) {
        int[] tasks = {2,2,3,7,1};
        int workers = 2;
        Solution5 s = new Solution5();
        System.out.println(s.shortest(tasks, workers));
    }
}

class Solution5 {
    public int shortest(int[] tasks, int workers) {
        if (tasks == null || tasks.length == 0) return 0;
        int[] sums = new int[tasks.length];
        int curSum = 0;
        for (int i = 0; i < tasks.length; i++) {
            curSum += tasks[i];
            sums[i] = curSum;
        }
//        return search(tasks, 0, workers, sums);
        return dpSolution(tasks, workers, sums);
    }

    private int search(int[] A, int idx, int k, int[] sums) {
        if (k == 1 || k > A.length - idx) {
            return idx == 0 ? sums[A.length - 1] : sums[A.length - 1] - sums[idx - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = idx; i <= A.length - k; i++) {
            int ret = search(A, i + 1, k - 1, sums);
            int curSum = idx == 0 ? sums[i] : sums[i] - sums[idx - 1];
            int max = Math.max(ret, curSum);
            min = Math.min(min, max);
        }
        return min;
    }

    private int dpSolution(int[] A, int workers, int[] sums) {
//        int[][] F = new int[A.length][workers + 1];
        int[][] F = new int[A.length][3];

        for (int i = A.length - 1; i >= 0; i--) {
            for (int k = 1; k <= workers; k++) {
                if (k == 1) {
                    F[i][k % 3] = i == 0 ? sums[A.length - 1] : sums[A.length - 1] - sums[i - 1];
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int j = i; j <= A.length - k; j++) {
                    int ret = F[j + 1][(k - 1) % 3];
                    int curSum = i == 0 ? sums[j] : sums[j] - sums[i - 1];
                    int max = Math.max(ret, curSum);
                    min = Math.min(min, max);
                }
                F[i][k % 3] = min;
            }
        }
        return F[0][workers % 3];
    }
}


