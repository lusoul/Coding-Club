package com.caden.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        double lNum = 92233720368547758099223372036854775809.0;

        System.out.println(lNum);
        int[] A = {-34,-52,72,75,-12};
        SolutionIS s = new SolutionIS();
        List<List<Integer>> ret = s.findSubsequences(A);
        for (List<Integer> l : ret) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class SolutionIS {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length < 2) return ret;
        dfs(ret, new ArrayList<Integer>(), 0, nums, set);
        return ret;
    }
    private void dfs(List<List<Integer>> ret, List<Integer> path, int startPos, int[] A, Set<List<Integer>> set) {
        if (path.size() > 1 && !set.contains(path)) {
            ret.add(new ArrayList<Integer>(path));
            set.add(new ArrayList<Integer>(path));
        }
        for (int i = startPos; i < A.length; i++) {
            if (path.size() != 0 && A[i] < path.get(path.size() - 1)) continue;
            path.add(A[i]);
            dfs(ret, path, i + 1, A, set);
            path.remove(path.size() - 1);
        }
    }
}


