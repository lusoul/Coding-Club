package com.caden.leetcode.amazon.OA;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 解法：就是extend两次而已
 */
public class LongestPalindromeSubstring {
}

class SolutionLongestPalindromeSubstring {
    String ret = "";
    int max = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return ret;
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return ret;
    }
    private void extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (end - start + 1 > max) {
                max = end - start + 1;
                ret = s.substring(start, end + 1);
            }
            start--;
            end++;
        }
    }
}
