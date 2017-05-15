package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在 个post  找出所有的name分别出现的位置, post会很长,name很多，用Trie存所有name，然后遍历post，k为名字长度，n为post长度，复杂度n*k^2
 */
public class FindNameInPost {
    public static void main(String[] args) {
        SolutionFindNameInPost s = new SolutionFindNameInPost();
        String post = "luling loves wangy but wangya don't care if nathan is with caden, caden loves nathan and luling do you know his name is cade.";
        List<String> names = new ArrayList<>();
        names.add("luling");names.add("caden");names.add("nathan");names.add("wangya");
        Map<String, List<Integer>> map = s.getPos(post, names);
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> pos = entry.getValue();
            System.out.print(name + ":");
            for (Integer p : pos) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}

class SolutionFindNameInPost {
    public Map<String, List<Integer>> getPos(String post, List<String> names) {
        Map<String, List<Integer>> ret = new HashMap<>();
        FindNamePostTrie trie = new FindNamePostTrie();
        for (String name : names) {
            trie.insert(name);
        }
        for (int start = 0; start < post.length(); start++) {
            for (int i = start; i < post.length(); i++) {
                String word = post.substring(start, i + 1);
                if (!trie.startWith(word)) break;
                if (trie.search(word)) {
                    if (ret.containsKey(word)) {
                        ret.get(word).add(start);
                    } else {
                        List<Integer> posList = new ArrayList<>();
                        posList.add(start);
                        ret.put(word, posList);
                    }
                }
            }
        }
        return ret;
    }
}

class FindNamePostTrie {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }
    TrieNode root;
    public FindNamePostTrie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        insert(root, word, 0);
    }
    private void insert(TrieNode cur, String word, int idx) {
        if (idx == word.length()) {
            cur.endOfWord = true;
            return;
        }
        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) {
            TrieNode kid = new TrieNode();
            cur.map.put(c, kid);
            insert(kid, word, idx + 1);
        } else {
            insert(cur.map.get(c), word, idx + 1);
        }
    }
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode cur, String word, int idx) {
        if (idx == word.length()) return cur.endOfWord;
        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) return false;
        return search(cur.map.get(c), word, idx + 1);
    }
    public boolean startWith(String word) {
        return startWith(root, word, 0);
    }
    private boolean startWith(TrieNode cur, String word, int idx) {
        if (idx == word.length()) return true;
        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) return false;
        return startWith(cur.map.get(c), word, idx + 1);
    }
}
