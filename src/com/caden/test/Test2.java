package com.caden.test;
public class Test2 {
    public static void main(String[] args) {
        Solutionkl s = new Solutionkl();
        int[] A = {6,1,3,2,4,7};
        System.out.println(s.maxProfit(A));
    }
}

class Solutionkl {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        return search(prices, 0, 0);
    }
    private int search(int[] A, int idx, int layer) {
        if (idx >= A.length || layer > 3) return 0;
        if (layer == 3) return A[idx];

        int ret = Integer.MIN_VALUE;
        for (int i = idx; i < A.length; i++) {
            if (layer == 0 || layer == 2) {
                int kid = search(A, i + 1, layer + 1);
                ret = Math.max(ret, -A[i] + kid);
            } else {
                int kid = search(A, i + 1, layer + 1);
                ret = Math.max(ret, A[i] + kid);
            }
        }
        return ret;
    }
}


