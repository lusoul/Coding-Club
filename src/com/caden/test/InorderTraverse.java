package com.caden.test;

import com.caden.leetcode.LinkedListToBalancedBinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraverse {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        List<String> ret = serialize(root);
        for (String s : ret) {
            System.out.print(s + " ");
        }
        System.out.println();
        TreeNode r = deserialize(ret);
        printOutTree(r);
    }


    public static List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            list.add("#");
            return list;
        }

        List<String> left = serialize(root.left);
        List<String> right = serialize(root.right);

        list.addAll(left);
        list.add(String.valueOf(root.val));
        list.addAll(right);

        return list;
    }
    static int idx = 0;
    public static TreeNode deserialize(List<String> list) {
        if (list.get(idx).equals("#")) return null;

        TreeNode left = deserialize(list);
        TreeNode root = new TreeNode(Integer.valueOf(list.get(idx)));
        idx++;

        TreeNode right = deserialize(list);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void printOutTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur == null ? "# "  : cur.val + " ");
                if (cur != null) {
                    queue.offer(cur.left);
                }
                if (cur != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }
}
