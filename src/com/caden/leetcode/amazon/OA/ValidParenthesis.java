package com.caden.leetcode.amazon.OA;

/**
 * 给你一个str,里面只有 '('和‘)’,让你数valid pairs一共有多少,如果不是valid就返回-1.
 * (判断是不是valid的parenthesis string，不是的话返回-1，是的话返回valid pair个数，即String.length() / 2 )
 *
 * 我的解法都不需要stack，因为这题是easy中的easy，只有（）两个而已，没有{} []
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        SolutionValidParenthesis s = new SolutionValidParenthesis();
        String source = "((()()(()))";
        System.out.println(s.isValidParenthesis(source));
    }
}

class SolutionValidParenthesis {
    public boolean isValidParenthesis(String source) {
        if (source == null || source.length() <= 1) return false;
        int rmL = 0, rmR = 0;
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == '(') {
                rmL++;
            } else {
                if (rmL > 0) rmL--;
                else return false;
            }
        }
        return rmL == 0;
    }
}
