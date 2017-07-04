package com.caden.leetcode.facebook;

public class ConvertBSTtoDoubleLinkedList {
    static class TreeNode {
        int val;
        TreeNode prev, next;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode tail = new TreeNode(0);
    public TreeNode convert(TreeNode root) {
        if (root.left == null && root.right == null) {
            tail = root;
            return root;
        }
        TreeNode left = null, right = null;
        if (root.left != null) {
            left = convert(root.left);
            tail.next = root;
            root.prev = tail;
            tail = root;
        }
        if (root.right != null) {
            right = convert(root.right);
            root.next = right;
            right.prev = root;
        }
        return left == null ? root : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(17);
        root.left = n1; root.right = n4; n1.left = n2; n2.right = n3; n4.left=n5;n4.right=n6;
        ConvertBSTtoDoubleLinkedList c = new ConvertBSTtoDoubleLinkedList();

        tail = root;
        TreeNode head = c.convert2(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public TreeNode convert2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            tail = root;
            return root;
        }

        TreeNode left = convert2(root.left);
        if (left != null) {
            tail.next = root;
            root.prev = tail;
            tail = root;
        }
        TreeNode right = convert2(root.right);
        if (right != null) {
            root.next = right;
            right.prev = root;
        }
        return left == null ? root : left;
    }
}


