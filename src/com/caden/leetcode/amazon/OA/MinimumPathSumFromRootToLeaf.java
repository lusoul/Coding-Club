package com.caden.leetcode.amazon.OA;

/**
 * Created by lusoul on 2017/5/8.
 */
public class MinimumPathSumFromRootToLeaf {
}

class SolutionMinimumPathSumFromRootToLeaf {
    public int minPath(TreeNode root) {
        if (root == null) return 0;
        return search(root);
    }
    public int search(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.val;
        return Math.min(search(root.left), search(root.right)) + root.val;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}


