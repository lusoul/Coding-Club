package com.caden.test;

import java.util.Deque;
import java.util.LinkedList;

public class Test4 {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.isValid("q"));
        System.out.println(String.valueOf(34));
        String str = "ahbld";

        System.out.println();
    }
}

class Solution6 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return false;
        char[] chs = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < chs.length; i++) {
            //if it's left parentheses, directly push into stack
            if (chs[i] == '(' || chs[i] == '{' || chs[i] == '[') {
                stack.push(chs[i]);
            } else {
                if (isLetter(chs[i])) continue;
                if (stack.isEmpty()) {
                    return false;
                }

                char left = stack.pop();
                if (chs[i] == ')' && left == '(' ||
                        chs[i] == ']' && left == '[' ||
                        chs[i] == '}' && left == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLetter(char c) {
        if (c != '(' && c != ')' &&
                c != '[' && c != ']' &&
                c != '{' && c != '}') {
            return true;
        }
        return false;
    }
}
