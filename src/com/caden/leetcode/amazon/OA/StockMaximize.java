package com.caden.leetcode.amazon.OA;

/**
 * 这题意思就是你连续买了两支股票，第三天你卖出去的时候，profit= price[3]*2 - (price[1]+price[2])。但是第三天你也可以选择只卖出去一支股票，手上还留着一支。
 这题有一个很聪明的解法，就是从数组尾巴开始扫，确定一个max，然后profit就等于max-cur的累加和就好了。
 比如输入: 6, 10, 8, 2, 6 20
 max=20, maxProfit = (20-6)+(20-2)+(20-8)+(20-10)+(20-6)
 */
public class StockMaximize {
    public static void main(String[] args) {
        int[] stocks = {6, 10, 8, 2, 6, 20};
        SolutionStockMaximize s = new SolutionStockMaximize();
        System.out.println(s.maxProfit(stocks));
    }
}

class SolutionStockMaximize {
    public int maxProfit(int[] stocks) {
        if (stocks == null || stocks.length == 0) return 0;
        int max = stocks[stocks.length - 1], profit = 0;
        for (int i = stocks.length - 1; i >= 0; i--) {
            max = Math.max(max, stocks[i]);
            profit += max - stocks[i];
        }
        return profit;
    }
}