package com.caden.leetcode.amazon.OA;

/**
 * 判断string1和string2是否互为right rotation。比如：abcd和cdab。
 */
public class RightRotation {
    public static void main(String[] args) {
        SolutionRightRotation s = new SolutionRightRotation();
        String word1 = "abcd", word2 = "caab";
        System.out.println(s.isRightRotate(word1, word2));
    }
}

class SolutionRightRotation {
    public boolean isRightRotate(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) return false;
        if (word1.length() != word2.length()) return false;
        String s = word1 + word1;
        return s.indexOf(word2) != -1;
    }
}
