package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * print the boundary of the Binary Tree. For example.

            1
         /    \
        2      3
       / \    / \
      4   5  6   7
     /    \   \
    8     9   10
 Answer will be : 1, 2, 4, 8, 9, 10, 7, 3
 */
public class PrintBinaryTreeBoundray {
    public static void main(String[] args) {
        String s = "abc";

        char c = '1';
        System.out.println((char)('A' + 1));
        System.out.println((int)'A');
        System.out.println((int)c);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        PrintBinaryTreeBoundray p = new PrintBinaryTreeBoundray();
        List<Integer> path = p.traverseTree(root);
        for (Integer i : path) System.out.print(i + " ");
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> path = new ArrayList<>();
    public List<Integer> traverseTree(TreeNode root) {
        leftSide(root);
        allLeaf(root);
        rightSide(root);
        path.remove(path.size() - 1);
        return path;
    }

    private void leftSide(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        path.add(root.val);
        leftSide(root.left);
    }
    private void allLeaf(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path.add(root.val);
        }
        allLeaf(root.left);
        allLeaf(root.right);
    }
    private void rightSide(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        rightSide(root.right);
        path.add(root.val);
    }
}


