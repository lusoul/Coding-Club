package com.caden.leetcode.facebook;

/**
 * input could include ":(" frown or ":)" smileys
 check if the input is parenthese balance
 */
public class SmileFrownParentheseBalanceCheck {
    public static void main(String[] args) {
        SolutionCheckBalanced s = new SolutionCheckBalanced();
        String message = ":()";
        System.out.println(s.check(message));
    }
}

class SolutionCheckBalanced {
    public boolean check(String message) {
        int needClose = 0, open = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '(') {
                open++;
                if (i == 0 || message.charAt(i - 1) != ':') {
                    needClose++;
                }
            } else if (message.charAt(i) == ')') {
                needClose = Math.max(0, needClose - 1);
                if (i == 0 || message.charAt(i - 1) != ':') {
                    open--;
                    if (open < 0) break;
                }
            }
        }
        if (open >= 0 && needClose == 0) return true;
        return false;
    }
}