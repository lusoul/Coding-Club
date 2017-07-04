package com.caden.leetcode.facebook;


import java.util.HashMap;
import java.util.Map;

public class AddandSearchWord_211 {
    public static void main(String[] args) {
    }
}

class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        addWord(root, word, 0);
    }
    private void addWord(TrieNode cur, String word, int idx) {
        if (idx == word.length()) {
            cur.endOfWord = true;
            return;
        }
        if (!cur.map.containsKey(word.charAt(idx))) {
            TrieNode kid = new TrieNode();
            cur.map.put(word.charAt(idx), kid);
            cur = kid;
        } else {
            TrieNode kid = cur.map.get(word.charAt(idx));
            cur = kid;
        }
        addWord(cur, word, idx + 1);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode cur, String word, int idx) {
        if (idx == word.length()) {
            return cur.endOfWord;
        }
        if (word.charAt(idx) != '.' && !cur.map.containsKey(word.charAt(idx))) {
            return false;
        }

        if (word.charAt(idx) == '.') {
            boolean ret = false;
            for (Map.Entry<Character, TrieNode> entry : cur.map.entrySet()) {
                ret = ret || search(entry.getValue(), word, idx + 1);
            }
            return ret;
        }
        //不是'.'
        return search(cur.map.get(word.charAt(idx)), word, idx + 1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");