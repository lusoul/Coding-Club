package com.caden.leetcode;

/**
 * Created by lusoul on 2017/4/19.
 */
public class CommonSubstringLargerThanK {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "coeyabc";

        System.out.println(dp(s1, s2));
    }
    public static boolean dp(String s1, String s2) {
        int[][] F = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    F[i][j] = F[i - 1][j - 1] + 1;
                    if (F[i][j] >= 3) return true;
                }
            }
        }
        return false;
    }
}
