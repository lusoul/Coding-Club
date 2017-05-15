package com.caden.leetcode.amazon.OA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 递减Deque
 */
public class SlidingWindowMaximum {
}

class SolutionSlidingWindowMaximum {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) return ret;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && nums[i - k] == deque.peekFirst()) deque.pollFirst();

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }

            deque.offer(nums[i]);
            if (i >= k - 1) ret.add(deque.peekFirst());
        }
        return ret;
    }
}