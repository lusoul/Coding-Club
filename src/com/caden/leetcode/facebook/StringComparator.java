package com.caden.leetcode.facebook;

/**
 * 自然string comparator。就是string 比较的时候考虑里面数字的大小，比如 abc9 < abc123 abc > ab9  因为char比digit重要。
 */
public class StringComparator {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abd";
        System.out.println(compare(s1, s2));
    }

    public static int compare(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0, j = 0;
        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                if (Character.isLetter(c1[i]) && Character.isLetter(c2[j])) {
                    return c1[i] - c2[j];
                } else if (Character.isLetter(c1[i])) {
                    return 1;
                } else if (Character.isLetter(c2[j])) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        if (c1.length < c2.length) return -1;
        else if (c1.length == c2.length) return 0;
        return 1;
    }
}
