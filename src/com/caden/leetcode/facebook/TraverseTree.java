package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseTree {
    public static void main(String[] args) {
        int i = 2;
        char c = (char)(i + '0');
        System.out.println(c);


        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1; root.right = node2;
        node1.right = node3;node2.left = node4;
        node3.left = node5;node2.right = node6;
        TraverseTree t = new TraverseTree();
        List<String> list = t.binaryTreePaths(root);
        for (String s : list) {
            System.out.println(s);
        }
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<String> allPath(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(ret, "", root);
        return ret;
    }
    private void dfs(List<String> ret, String path, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path = path + root.val;
            ret.add(path);
            return;
        }

        path = path + root.val + "->";
        dfs(ret, path, root.left);
        dfs(ret, path, root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        pathQueue.offer(root.val + "");
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            String path = pathQueue.poll();
            if (cur.left == null && cur.right == null) {
                res.add(path);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                pathQueue.offer(path + "->" + cur.left.val + "");
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                pathQueue.offer(path + "->" + cur.right.val + "");
            }
        }
        return res;
    }
}


