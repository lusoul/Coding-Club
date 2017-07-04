package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TasksToWorker {
    public static void main(String[] args) {
        int[] tasks = {7,1,2,5,8,9,1,4};
        int workers = 4;
        Solution5 s = new Solution5();
        System.out.println(s.shortest(tasks, workers));
        //----------------------------------
        SolutionTasksToWork ss = new SolutionTasksToWork();
        List<List<Integer>> ret = ss.getArrange(tasks, workers);
        for (List<Integer> list : ret) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

//以下是正确的解法使用Heap
class SolutionTasksToWork {
    public List<List<Integer>> getArrange(int[] tasks, int workers) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        PriorityQueue<WrapList> wHeap = new PriorityQueue<>(new Comparator<WrapList>() {
            @Override
            public int compare(WrapList w1, WrapList w2) {
                return w1.sum - w2.sum;
            }
        });

        for (int i : tasks) maxHeap.offer(i);//O(n)
        while (!maxHeap.isEmpty()) {//O(logn * logn)
            int cur = maxHeap.poll();
            if (wHeap.size() < workers) {
                WrapList wList = new WrapList();
                wList.sum += cur;
                wList.list.add(cur);
                wHeap.offer(wList);
            } else {
                WrapList wList = wHeap.poll();
                wList.sum += cur;
                wList.list.add(cur);
                wHeap.offer(wList);
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        while (!wHeap.isEmpty()) {// < O(nlogn), because log1+log2+log3+...logn=log(1*2*..*n)=log(n!)<log(n^n)=nlogn
            ret.add(wHeap.poll().list);
        }
        return ret;
    }
    class WrapList {
        int sum;
        List<Integer> list = new ArrayList<>();
    }
}

//以下是错误的解法DP
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


