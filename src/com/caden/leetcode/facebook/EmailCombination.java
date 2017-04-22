package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given 1 million email list:
 list 1: a@a.com, b@b.com
 list 2: b@b.com, c@c.com
 list 3: e@e.com
 list 4: a@a.com
 ...
 Combine lists with identical emails, and output tuples:
 (list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
 (list 3) (e@e.com)
 */
public class EmailCombination {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> line1 = new ArrayList<>();line1.add("List 1");line1.add("a@a.com");line1.add("b@b.com");
        List<String> line2 = new ArrayList<>();line2.add("List 2");line2.add("b@b.com");line2.add("c@c.com");
        List<String> line3 = new ArrayList<>();line3.add("List 3");line3.add("e@e.com");
        List<String> line4 = new ArrayList<>();line4.add("List 4");line4.add("a@a.com");
        List<String> line5 = new ArrayList<>();line5.add("List 5");line5.add("c@c.com");line5.add("d@d.com");line5.add("g@g.com");
        List<String> line6 = new ArrayList<>();line6.add("List 6");line6.add("e@e.com");line6.add("k@k.com");
        List<String> line7 = new ArrayList<>();line7.add("List 7");line7.add("m@m.com");line7.add("n@n.com");
        List<String> line8 = new ArrayList<>();line8.add("List 8");line8.add("n@n.com");line8.add("g@g.com");
        list.add(line1);list.add(line2);list.add(line3);list.add(line4);
        list.add(line5);list.add(line6);list.add(line7);list.add(line8);

        EmailCombination ec = new EmailCombination();
        List<List<String>> ret = ec.getSameList(list);
        for (List<String> l : ret) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public List<List<String>> getSameList(List<List<String>> input) {
        List<List<String>> ret = new ArrayList<>();
        //1. get email and idx list mapping
        Map<String, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 1; j < input.get(i).size(); j++) {
                String email = input.get(i).get(j);
                if (idxMap.containsKey(email)) {
                    idxMap.get(email).add(i);
                } else {
                    List<Integer> idxList = new ArrayList<>();
                    idxList.add(i);
                    idxMap.put(email, idxList);
                }
            }
        }

        //2. combine them
        UF uf = new UF(input.size());
        for (Map.Entry<String, List<Integer>> entry : idxMap.entrySet()) {
            List<Integer> list = entry.getValue();
            for (Integer i : list) {
                uf.union(i, list.get(0));
            }
        }

        //3. traverse id[]
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            int root = uf.find(i);
            if (map.containsKey(root)) {
                map.get(root).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(root, list);
            }
        }

        //4. get result
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (Integer i : entry.getValue()) {
                list.add(input.get(i).get(0));
            }
            ret.add(list);
        }
        return ret;
    }

    class UF {
        int[] id;
        int[] size;

        public UF(int capacity) {
            this.id = new int[capacity];
            this.size = new int[capacity];
            for (int i = 0; i < capacity; i++) {
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
}
