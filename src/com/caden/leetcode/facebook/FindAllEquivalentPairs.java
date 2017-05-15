package com.caden.leetcode.facebook;

import java.util.*;

/**
 * Given an array A of integers, find the index of values that satisfy A
 + B =C + D, where A,B,C & D are integers values in the array. Find all
 combinations of quadruples.
 */
public class FindAllEquivalentPairs {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<List<Integer>> set= new HashSet<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        list2.add(3);list2.add(2);list2.add(1);list2.add(4);
        Collections.sort(list);
        Collections.sort(list2);
        set.add(list);
        set.add(list2);
        System.out.println(set.size());

        int[] A = {5,8,4,0,-3,2,-6,7};
        SolutionFindAllEquivalentPairs s = new SolutionFindAllEquivalentPairs();
        List<int[]> ret = s.find(A);
        for (int[] l : ret) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class SolutionFindAllEquivalentPairs {
    public List<int[]> find(int[] A) {
        List<int[]> ret = new ArrayList<>();
        Set<List<Integer>> retSet = new HashSet<>();
        if (A == null || A.length == 0) return ret;
        Map<Integer, List<int[]>> map = new HashMap<>();//map存放两两相加和，key为和，value为两个idx(int[])的集合，因为可能sum重复
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (!map.containsKey(sum)) {
                    List<int[]> list = new ArrayList<>();
                    int[] idxs = {i, j};
                    list.add(idxs);
                    map.put(sum, list);
                } else {
                    int[] idxs = {i, j};
                    map.get(sum).add(idxs);
                }
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (!map.containsKey(sum)) continue;
                List<int[]> idxList = map.get(sum);
                for (int[] idxs : idxList) {
                    if (idxs[0] == i || idxs[0] == j) continue;
                    if (idxs[1] == i || idxs[1] == j) continue;
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(idxs[0]);
                    list.add(idxs[1]);
                    Collections.sort(list);
                    if (!retSet.contains(list)) {
                        retSet.add(list);
                        ret.add(new int[]{i, j, idxs[0], idxs[1]});
                    }
                }
            }
        }
        return ret;
    }
}
