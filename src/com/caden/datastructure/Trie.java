package com.caden.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;
        public TrieNode() {
            this.map = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        add(word, 0, root);
    }
    private void add(String word, int idx, TrieNode cur) {
        if (idx == word.length()) {
            cur.endOfWord = true;
            return;
        }
        char c = word.charAt(idx);
        if (cur.map.containsKey(c)) {
            TrieNode kid = cur.map.get(c);
            add(word, idx + 1, kid);
        } else {
            TrieNode kid = new TrieNode();
            cur.map.put(c, kid);
            add(word, idx + 1, kid);
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int idx, TrieNode cur) {
        if (idx == word.length()) return cur.endOfWord;
        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) return false;
        return search(word, idx + 1, cur.map.get(c));
    }

    public boolean startWith(String word) {
        return startWith(word, 0, root);
    }
    private boolean startWith(String word, int idx, TrieNode cur) {
        if (idx == word.length()) return true;
        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) return false;
        return startWith(word, idx + 1, cur.map.get(c));
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("world");
        trie.add("welcome");
        System.out.println(trie.search("world"));
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("worlde"));
        System.out.println(trie.startWith("world"));
        System.out.println(trie.startWith("wor"));
        System.out.println(trie.startWith("wal"));
    }
}
