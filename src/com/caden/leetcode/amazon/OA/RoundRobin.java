package com.caden.leetcode.amazon.OA;

import java.util.Deque;
import java.util.LinkedList;

/**
 * input: ArrivalTime={0,2,4,5}. ExcutionTime={7,4,1,4},每个任务可执行时间q=3秒，求average wait time。
 首先A[]表示每个任务的到达时间，E[]表示每个任务执行完所需时间，q表示每个任务一次最多只能执行3秒，由于每个任务不是一次性执行完，所以需要等待，求所有等待时间/任务个数=average wait time.
 workflow：假设A[]有4个任务，分别为A,B,C,D,然后列出它们的到达时间和执行时间就是：
 A(0,7), B(2,4), C(4, 1), D(5, 4). 括号中第一位表示开始时间（达到时间）用A(a)表示，第二位表示执行时间用A(e)表示

 看有道词典具体分析
 */
public class RoundRobin {
    public static void main(String[] args) {
        SolutionRoundRobin s = new SolutionRoundRobin();
        int[] A = {0,2,4,5};
        int[] E = {7,4,1,4};
        int q = 3;
        System.out.println(s.SolutionII(A, E, q));
    }
}



class SolutionRoundRobin {
    public float SolutionII(int[] A, int[] E, int q) {
        if (A == null || A.length == 0 || E == null || E.length == 0 || A.length != E.length || q <= 0) return 0;
        Deque<Task> queue = new LinkedList<>();
        int idx = 0;
        int curTime = 0, endTime = 0, waitTime = 0;
        //为什么需要idx < A.length ?因为可能有一个task的开始时间很靠后，此时queue就是空的
        while (!queue.isEmpty() || idx < A.length) {
            if (!queue.isEmpty()) {
                Task cur = queue.poll();
                waitTime += curTime - cur.aTime;
                curTime += Math.min(q, cur.eTime);
                while (idx < A.length && A[idx] <= curTime) {//扫描A数组，要把时间小于endTime的任务加到Queue里
                    queue.offer(new Task(A[idx], E[idx]));
                    idx++;
                }
                if (cur.eTime > q) queue.offer(new Task(curTime, cur.eTime - q));

            } else {
                queue.offer(new Task(A[idx], E[idx]));
                curTime = A[idx++];//这里要注意设置curTime
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
