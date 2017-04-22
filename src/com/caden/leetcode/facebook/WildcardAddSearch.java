package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lusoul on 2017/4/4.
 */
public class WildcardAddSearch {
    public static void main(String[] args) {
        WildcardAddSearch trie = new WildcardAddSearch();
        trie.add("ab");
        trie.add("aac");
        trie.add("ac");
        trie.add("bbcd");
        System.out.println(trie.root.maxHeight);
        List<String> ret = trie.search("*d");
        for (String s : ret) System.out.println(s);
    }

    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        int maxHeight;
        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
            maxHeight = 0;
        }
    }

    TrieNode root;
    public WildcardAddSearch() {
        root = new TrieNode();
    }

    public void add(String word) {
        add(root, 0, word);
    }
    private int add(TrieNode cur, int idx, String word) {
        if (idx == word.length()) {
            cur.endOfWord = true;
            cur.maxHeight = 0;
            return 0;
        }

        char c = word.charAt(idx);
        if (cur.map.containsKey(c)) {
            int height = add(cur.map.get(c), idx + 1, word);
            if (cur.maxHeight < height + 1) {
                cur.maxHeight = height + 1;
            }
        } else {
            TrieNode kid = new TrieNode();
            cur.map.put(c, kid);
            int height = add(kid, idx + 1, word);
            if (cur.maxHeight < height + 1) {
                cur.maxHeight = height + 1;
            }
        }
        return cur.maxHeight;
    }

    public List<String> search(String word) {
        List<String> ret = new ArrayList<>();
        search(ret, new String(), root, 0, word);
        return ret;
    }
    private void search(List<String> ret, String path, TrieNode cur, int idx, String word) {
        if (idx == word.length()) {
            if (cur.endOfWord) {
                ret.add(path);
            }
            return;
        }

        char c = word.charAt(idx);
        if (c == '*') {
            if (word.length() - idx - 1 > cur.maxHeight) return;
            else if (word.length() - idx - 1 == cur.maxHeight) {
                search(ret, path, cur, idx + 1, word);
            } else {
                for (Map.Entry<Character, TrieNode> entry : cur.map.entrySet()) {
                    search(ret, path + entry.getKey(), entry.getValue(), idx, word);
                }
            }

        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : cur.map.entrySet()) {
                search(ret, path + entry.getKey(), entry.getValue(), idx + 1, word);
            }
        } else { //letter
            if (!cur.map.containsKey(c)) return;
            search(ret, path + c, cur.map.get(c), idx + 1, word);
        }
    }
}


