package com.caden.leetcode.facebook;

public class BestTimetoBuyandSellStock_121 {
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], max = prices[0], ret = 0;
        for (int price : prices) {
            if (price < min) min = price;
            max = price;
            ret = Math.max(ret, max - min);
        }
        return ret;
    }
}