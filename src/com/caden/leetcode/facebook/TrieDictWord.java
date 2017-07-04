package com.caden.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个字典包括很多字符串(e.g., abcd, dhfyf)，然后给定一个字符串查看字典中是否包含这个字符串。字符串中可能包括*，*可以匹配任何字符
 */
public class TrieDictWord {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");trie.insert("world");trie.insert("luling");trie.insert("wangya");
        trie.insert("candelu");trie.insert("nathan");trie.insert("welcome");trie.insert("seattle");
        trie.insert("sayhi");trie.insert("highschool");trie.insert("awesome");trie.insert("facebook");
        trie.insert("google");trie.insert("amazon");trie.insert("microsoft");trie.insert("uber");

        String word = "high*chool";
        System.out.println(trie.search(word));
    }
}

class Trie {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;
    public Trie() {
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
        if (idx == word.length()) {
            return cur.endOfWord;
        }

        char c = word.charAt(idx);
        if (c == '*') {
            boolean ret = false;
            for (Map.Entry<Character, TrieNode> entry : cur.map.entrySet()) {
                ret |= search(entry.getValue(), word, idx + 1);
            }
            return ret;
        } else if (!cur.map.containsKey(c)) {
            return false;
        } else {
            return search(cur.map.get(c), word, idx + 1);
        }
    }
}
