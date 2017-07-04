package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个tree，每个node 有很多children，
 找到所有最深的nodes 的common  ancestor,
 比如只有一个点最深，那返回他自己。
 */
public class LCAofTreeWithMultipleNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);Node n2 = new Node(2);Node n3 = new Node(3);Node n4 = new Node(4);Node n5 = new Node(5);
        Node n6 = new Node(6);Node n7 = new Node(7);Node n8 = new Node(8);Node n9 = new Node(9);Node n10 = new Node(10);
        Node n11 = new Node(11);Node n12 = new Node(12);Node n13 = new Node(13);Node n14 = new Node(14);Node n15 = new Node(15);
        Node n16 = new Node(16);Node n17 = new Node(17);Node n18 = new Node(18);Node n19 = new Node(19);Node n20 = new Node(20);
        Node n21 = new Node(21);Node n22 = new Node(22);Node n23 = new Node(23);Node n24 = new Node(24);Node n25 = new Node(25);
        Node n26 = new Node(26);Node n27 = new Node(27);
        n1.kids.add(n2);n1.kids.add(n3);n1.kids.add(n4);n1.kids.add(n5);
        n2.kids.add(n6);n6.kids.add(n15);n15.kids.add(n20);n3.kids.add(n7);n3.kids.add(n8);n3.kids.add(n9);
        n4.kids.add(n10);n4.kids.add(n11);n4.kids.add(n12);n4.kids.add(n13);n5.kids.add(n14);
        n7.kids.add(n16);n7.kids.add(n17);n7.kids.add(n18);n9.kids.add(n19);
        n18.kids.add(n21);n19.kids.add(n24);n19.kids.add(n26);
        n21.kids.add(n22);n21.kids.add(n23);n21.kids.add(n25);n26.kids.add(n27);

        LCAofTreeWithMultipleNode l = new LCAofTreeWithMultipleNode();
        Node ret = l.LCA(n1);
        System.out.println(ret.val);
    }

    static class Node {
        int val;
        List<Node> kids;
        public Node(int val) {
            this.val = val;
            kids = new ArrayList<>();
        }
    }

    class ResultType {
        Node node;
        int max;
        public ResultType(Node node, int max) {
            this.node = node;
            this.max = max;
        }
    }

    public Node LCA(Node root) {
        return dfs(root, 1).node;
    }

    private ResultType dfs(Node root, int depth) {
        if (root == null) return new ResultType(new Node(0), Integer.MIN_VALUE);

        if (root.kids.size() == 0) {
            return new ResultType(root, depth);
        }
        int max = 0;
        Node val = new Node(0);
        for (Node node : root.kids) {
            ResultType kid = dfs(node, depth + 1);
            if (kid.max > max) {
                max = kid.max;
                val = kid.node;
            } else if (kid.max == max) {
                val = root;
            }
        }
        return new ResultType(val, max);
    }
}
