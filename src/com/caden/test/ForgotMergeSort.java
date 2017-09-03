package com.caden.test;

import java.util.*;

public class ForgotMergeSort {
    public static void main(String[] args) {
        int[] A = {5,7,2,8,9,1,6};
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIdx = j;
                }
            }
            swap(A, i, minIdx);
        }

        for (int i : A) System.out.print(i + " ");
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
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
        if (!cur.map.containsKey(c)) {
            return false;
        } else {
            return search(cur.map.get(c), word, idx + 1);
        }
    }

    public boolean startWith(String word) {
        return startWith(root, word, 0);
    }
    private boolean startWith(TrieNode cur, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        char c = word.charAt(idx);
        if (!cur.map.containsKey(c)) {
            return false;
        } else {
            return startWith(cur.map.get(c), word, idx + 1);
        }
    }
}



class SegmentTree {
    class TreeNode {
        int start, end, min;
        TreeNode left, right;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public TreeNode buildTree(int[] A, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            TreeNode node = new TreeNode(start, end);
            node.min = A[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(start, end);
        root.left = buildTree(A, start, mid);
        root.right = buildTree(A, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
        return root;
    }

    public int query(TreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) return Integer.MAX_VALUE;
        if (start <= root.start && end >= root.end) return root.min;
        return Math.min(query(root.left, start, end), query(root.right, start, end));
    }

    public void modify(TreeNode root, int idx, int val) {
        if (root == null || idx > root.end || idx < root.start) return;
        if (idx == root.start && idx == root.end) {
            root.min = val;
            return;
        }
        modify(root.left, idx, val);
        modify(root.right, idx, val);
        root.min = Math.min(root.left.min, root.right.min);
    }
}

// 第一步有这数据结构
//class UF {
//    int[] id;
//    public UF(int n);
//    public int find(int p);
//    public void union(int p, int q);
//}

// 第二步quick find
class UF1 {
    int[] id;
    public UF1(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pRoot) {
                id[i] = qRoot;
            }
        }
    }
}

// 第三步quick union
class UF2 {
    int[] id;
    public UF2(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
    }
}

// 第三步,由于第三步你是id[pId] = qId还是id[qId] = pId不知道,很可能会造成头重脚轻的形态,提高了find的复杂度.所以需要权重weighted
class UF3 {
    int[] id;
    int[] size;
    public UF3(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}

// 第四步, 压缩路径
class UF4 {
    int[] id;
    int[] size;
    public UF4(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}


