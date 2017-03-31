package com.caden.leetcode.facebook;

/**
 * binary tree转换成doubly linked list ->就是114.Flatten BT to LinkedList变种
 * And revert it back (reverted to balanced tree)这里没要去是BST，所以只要balanced就好了，也是用一个全局指针按照start，mid，end切分总是balanced的
 */
public class ChangeBTtoDoublyLinkedList {
    class TreeNode {
        TreeNode parent, left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode flatten(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTail = flatten(root.left);
        TreeNode rightTail = flatten(root.right);

        if (root.right != null)
            root.right.parent = leftTail;
        if (leftTail != null)
            leftTail.right = root.right;
        root.right = root.left;
        root.left = null;

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }

}

