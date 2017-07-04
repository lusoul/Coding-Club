package com.caden.datastructure;

public class UnionFindTest {
}

class UF {
    int[] id;
    int[] size;
    int count;

    public UF(int capacity) {
        id = new int[capacity];
        size = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            id[i] = i;
            size[i] = 1;
        }
        count = capacity;
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = id[p];
        int qRoot = id[q];
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = id[qRoot];
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = id[pRoot];
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}




