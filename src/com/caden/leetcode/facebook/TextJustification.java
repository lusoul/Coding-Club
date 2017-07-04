package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        String[] words = {"a", "b", "c", "d", "e"};
        int maxWidth = 3;
        List<String> ret = s.fullJustify(words, maxWidth);
        for (String str : ret) {
            System.out.println(str);
        }
    }
}

class Solution6 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, level = 1; i < row; i++, level++) {

            for (int j = 0; j <= col; j++) {
                int cur = Integer.MIN_VALUE;
                if (j != col) {
                    heights[j] += matrix[i][j];
                    cur = heights[j];
                }

                while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                    int idx = stack.pop();
                    int wid = j - (stack.isEmpty() ? -1 : stack.peek()) - 1;
                    int hi = heights[idx];
                    int min = Math.min(Math.min(wid, hi), level);
                    int area = min * min;
                    max = Math.max(max, area);
                }
                if (j != col) stack.push(j);
            }
        }
        return max;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        // if (words == null || words.length == 0) return ret;
        int total = 0, space = 0, wordAmount = 0, everySpace = 0, redundant = 0, originalLength = 0, start = 0;
        boolean first = true;

        for (int i = 0; i < words.length; i++) {
            if (first) {
                originalLength += words[i].length();
                first = false;
                wordAmount++;
                total += words[i].length();
            } else {
                originalLength = originalLength + 1 + words[i].length();
                wordAmount++;
                total += words[i].length();
                if (originalLength <= maxWidth) continue;
                // exceed the max width, begin to calculate
                wordAmount--;
                total -= words[i].length();
                space = maxWidth - total;
                everySpace = wordAmount == 1 ? 0 : space / (wordAmount - 1);
                redundant = wordAmount == 1 ? 0 : space - everySpace * (wordAmount - 1);
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < i; j++) {
                    if (redundant != 0) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, everySpace);
                            sb.append(" ");
                        }
                        redundant--;
                    } else {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, everySpace);
                        }
                    }
                }
                appendSpace(sb, maxWidth - sb.length());
                ret.add(sb.toString());
                start = i;
                wordAmount = 0;
                everySpace = 0;
                total = 0;
                space = 0;
                redundant = 0;
                originalLength = 0;
                first = true;
                i--;
            }
        }
        // judge if original length != 0
        // if (originalLength != 0) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            if (i == words.length - 1) sb.append(words[i]);
            else sb.append(words[i]).append(" ");
        }
        int leftSpace = maxWidth - sb.length();
        appendSpace(sb, leftSpace);
        ret.add(sb.toString());
        // }

        // if (ret.size() == 0) ret.add("");
        return ret;
    }

    private void appendSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }
}



