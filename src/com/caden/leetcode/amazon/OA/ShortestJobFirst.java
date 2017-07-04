package com.caden.leetcode.amazon.OA;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一个处理器要处理一堆request，一次只能处理一条，如果它有几个积压着的requests，它会先执行持续时间短的那个；
 * 对于持续时间相等的requests，先执行最早到达处理器的request。问平均每个request要等多久才能被处理。
 * input：requestTimes[]，每个request到达处理器的时间; durations[] 每个request要处理的持续时间。
 * 两个数组是一一对应的，并已按requestTimes[] 从小到大排序过

 public double CalWaitingTime(int requestTimes[], int[] durations[]){}

 这题和Round Robin一摸一样，而且还更简单
 */
public class ShortestJobFirst {
}

class SolutionShortestJobFirst {
    public float calWaitingTime(int[] A, int[] E) {
        if (A == null || A.length == 0 || E == null || E.length == 0 || A.length != E.length) return 0;
        int curTime = 0, waitTime = 0, idx = 0;
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.eTime == t2.eTime) return t1.aTime - t2.aTime;
                return t1.eTime - t2.eTime;
            }
        });

        while (!pq.isEmpty() || idx < A.length) {
            if (!pq.isEmpty()) {
                Task cur = pq.poll();
                waitTime += curTime - cur.aTime;
                curTime += cur.eTime;
                while (idx < A.length && A[idx] <= curTime) {
                    pq.offer(new Task(A[idx], E[idx]));
                    idx++;
                }
            } else {
                pq.offer(new Task(A[idx], E[idx]));
                curTime = A[idx++];
            }
        }
        return (float)waitTime / A.length;
    }

    class Task {
        int aTime;
        int eTime;
        public Task(int aTime, int eTime) {
            this.aTime = aTime;
            this.eTime = eTime;
        }
    }
}