package com.caden.test;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        SolutionPp s = new SolutionPp();
        int[] A = {5,3,1,-3,0,5,6,-9,4,2,12,11,-43,8,-7,2};
        s.dfs(A, 0, 0);
        System.out.println(s.amount);
    }

}

class SolutionPp {
    int amount = 0;
    public List<Integer> dfs(int[] A, int idx, int count) {
        List<Integer> ret = new ArrayList<>();
        if (count == 2) {
            for (int i = idx; i < A.length; i++) {
                ret.add(A[i]);
            }
            return ret;
        }
        if (count == 1 && idx == A.length - 1 || count == 0 && idx == A.length - 2) {
            return ret;
        }

        List<Integer> left = dfs(A, idx + 1, count + 1);
        List<Integer> right = dfs(A, idx + 1, count);
        for (Integer in : left) {
            ret.add(A[idx] + in);
        }
        for (Integer in : right) {
            ret.add(in);
        }
        if (count == 0) {
            for (Integer in : ret) {
                if (in < 12) amount++;
            }
        }

        return ret;
    }
}


