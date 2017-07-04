package com.caden.leetcode.facebook;

public class BestTimetoBuyandSellStockIII_123 {
}

// DFS+Cache
class Solution2 {
    int[][] cache;
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        cache = new int[prices.length][6];
        return search(prices, 0, 1);
    }

    private int search(int[] A, int idx, int count) {
        if (count == 5 || idx > A.length - 1) return 0;
        if (cache[idx][count] != 0) return cache[idx][count];
        int left = 0, right = 0, cur = A[idx], ret = 0;
        if (count == 1 || count == 3) {
            left = search(A, idx + 1, count + 1);
            right = search(A, idx + 1, count);
            ret = Math.max(left - cur, right);
        } else {
            left = search(A, idx + 1, count + 1);
            right = search(A, idx + 1, count);
            ret = Math.max(left + cur, right);
        }
        cache[idx][count] = ret;
        return ret;
    }
}

// convert above code to DP, time O(n), space O(n)
class Solution3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] F = new int[prices.length + 1][6];//这里一定要+1初始化，调试了我很久这里
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 5; j >= 1; j--) {
                if (j == 5) {
                    F[i][j] = 0;
                } else if (j == 4 || j == 2) {
                    int left = F[i + 1][j + 1];
                    int right = F[i + 1][j];
                    F[i][j] = Math.max(left + prices[i], right);
                } else if (j == 1 || j == 3) {
                    int left = F[i + 1][j + 1];
                    int right = F[i + 1][j];
                    F[i][j] = Math.max(left - prices[i], right);
                }
            }
        }
        return F[0][1];
    }
}
// optimize space to O(1)
class Solution4 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] F = new int[2][6];//这里一定要+1初始化，调试了我很久这里
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 5; j >= 1; j--) {
                if (j == 5) {
                    F[i % 2][j] = 0;
                } else if (j == 4 || j == 2) {
                    int left = F[(i + 1) % 2][j + 1];
                    int right = F[(i + 1) % 2][j];
                    F[i % 2][j] = Math.max(left + prices[i], right);
                } else if (j == 1 || j == 3) {
                    int left = F[(i + 1) % 2][j + 1];
                    int right = F[(i + 1) % 2][j];
                    F[i % 2][j] = Math.max(left - prices[i], right);
                }
            }
        }
        return F[0][1];
    }
}