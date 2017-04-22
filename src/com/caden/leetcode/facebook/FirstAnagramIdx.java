package com.caden.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * first index of anagram 的题目。
 * 栗子：原string：teacher, 如果target string用是eat, 能找到匹配，
 * 就返回一开始的index,这里返回0，如果target string 是arch, 就找不到匹配，返回－1
 */
public class FirstAnagramIdx {
    public static void main(String[] args) {
        String source = "reacaherahca";
        String target = "a";
        FirstAnagramIdx fai = new FirstAnagramIdx();
        System.out.println(fai.findFirstIdx(source, target));
    }

    public int findFirstIdx(String source, String target) {
        if (source == null || source.length() == 0) return -1;
        if (target == null || target.length() == 0) return -1;
        if (target.length() > source.length()) return -1;
        char[] s = source.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            if (map.containsKey(target.charAt(i))) {
                map.put(target.charAt(i), map.get(target.charAt(i)) + 1);
            } else {
                map.put(target.charAt(i), 1);
            }
        }

        int j = 0, i = 0, count = 0;
        while (j < s.length) {
            if (map.containsKey(s[j]) && map.get(s[j]) != 0) {
                map.put(s[j], map.get(s[j]) - 1);
                count++;
                j++;
                if (count == target.length()) return i;
            } else {
                if (i == j) j++;
                if (map.containsKey(s[i])) {
                    map.put(s[i], map.get(s[i]) + 1);
                    count--;
                }
                i++;
            }
        }
        return -1;
    }
}


