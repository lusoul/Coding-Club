package com.caden.leetcode.amazon.OA;

/**
 * 把一个字符串中的元音字母aeiouAEIOU删除，就是定义一个字符串s为aeiouAEIOU，然后枚举source中每个char，看s.indexOf(c)如果不为-1，说明是元音即可
 */
public class RemoveVowel {
    public static void main(String[] args) {
        SolutionRemoveVowel s = new SolutionRemoveVowel();
        String source = "Amzon is really terrific!";
        System.out.println(s.removeVowel(source));
    }
}
class SolutionRemoveVowel {
    public String removeVowel(String source) {
        if (source == null || source.length() == 0) return "";
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (vowels.indexOf(source.charAt(i)) > -1) continue;
            sb.append(source.charAt(i));
        }
        return sb.toString();
    }
}
