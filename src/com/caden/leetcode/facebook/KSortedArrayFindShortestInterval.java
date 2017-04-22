package com.caden.leetcode.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given k sorted array, each array has n posts, find the shortest interval contains at least 1 post from each array
 * Input:
 * K = 3
 * arr1[] : [4, 7, 9, 12, 15]
 * arr2[] : [0, 8, 10, 14, 20]
 * arr3[] : [6, 12, 16, 30, 50]
 * Output:
 * The smallest range is [6 8]
 * Explanation: Smallest range is formed by
 * number 7 from first list, 8 from second
 * list and 6 from third list.
 *
 * 这题说了每个array中至少有一个元素在interval中,所以有一个下标走出了范围就直接return就好了
 * 然后这题就是用minHeap来做，维护一个max表示当前heap中的最大值就好，这样就可以迅速求范围了
 */
public class KSortedArrayFindShortestInterval {
    public static void main(String[] args) {
        KSortedArrayFindShortestInterval ka = new KSortedArrayFindShortestInterval();
        int[][] A = {{4,7,9,12,15},
                {0,8,10,14,20},
                {6,12,16,30,50}};
        int[] ret = ka.shortestInterval(A);
        System.out.println(ret[0] + " " + ret[1]);
    }

    public int[] shortestInterval(int[][] A) {
        //k就是A.length了, 因为这里是数组，不像链表可以直接操作next获得元素放到heap中，所以我可以用一个Node{val, whichArray, idx}或者int[3]放到heap中
        //1. 把每个数组开头元素放到minHeap中
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] A, int[] B) {
                return A[0] - B[0]; //A[3]: 0 means val, 1 means which array, 2 means idx
            }
        });
        int[] ret = new int[2];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int[] node = {A[i][0], i, 0};
            pq.offer(node);
            max = Math.max(max, A[i][0]);
        }

        int range = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            //calcuate result
            int[] minNode = pq.peek();
            if (max - minNode[0] < range) {
                range = max - minNode[0];
                ret[0] = minNode[0];
                ret[1] = max;
            }

            int[] curNode = pq.poll();
            if (curNode[2] + 1 >= A[curNode[1]].length) return ret;
            int[] nextNode = {A[curNode[1]][curNode[2] + 1], curNode[1], curNode[2] + 1};
            if (nextNode[0] > max) {
                max = nextNode[0];
            }
            pq.offer(nextNode);
        }
        return ret;
    }
}
