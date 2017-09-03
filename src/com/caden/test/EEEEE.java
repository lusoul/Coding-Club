package com.caden.test;

/**
 * Created by lusoul on 2017/4/29.
 */
public class EEEEE {
    public static void main(String[] args) {
        String s = "aaab";
        String p = "b**";
        SolutionKTH solution = new SolutionKTH();
        System.out.println(solution.isMatch(s, p));
    }
}


class SolutionKTH {
    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) return true;
        if (p == null || p.length() == 0) return false;

//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        boolean[][] dp = new boolean[3][p.length() + 1];
        dp[0][0] = true;


        for (int j = 1; j <= p.length() ;j ++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '?') dp[i % 3][j] = dp[(i - 1) % 3][j - 1];
                else if (c2 == '*') {
                    dp[i % 3][j] = dp[i % 3][j - 1] || dp[(i - 1) % 3][j];
                }
            }
        }
        return dp[s.length() % 3][p.length()];

    }
}

