package com.caden.test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Test6 {
    public static void main(String[] args) {
        int[] A = {4,0,2,6};
        Solution98 s = new Solution98();
        System.out.println(s.findMinMoves(A));
    }
}

class Solution98 {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return -1;
        int sum = 0;
        for (int i = 0; i < machines.length; i++) sum += machines[i];
        if (sum % machines.length != 0) return -1;

        int count = 0;
        while (true) {
            Set<Integer> set = new HashSet<>();
            int minPos = 0, maxPos = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < machines.length; i++) {
                set.add(machines[i]);
                if (machines[i] > max) {
                    maxPos = i;
                    max = machines[i];
                }
                if (machines[i] < min) {
                    minPos = i;
                    min = machines[i];
                }
            }
            if (set.size() == 1) break;
            machines[minPos]++;
            machines[maxPos]--;
            count++;
        }
        return count;
    }
}



