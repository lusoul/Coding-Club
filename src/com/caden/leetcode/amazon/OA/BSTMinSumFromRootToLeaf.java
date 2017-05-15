package com.caden.leetcode.amazon.OA;

/**
 * 跟BST没啥关系，不要看到BST就以为是最左边的路径之和（左边路径可以很长，右边路径可以很短），用递归做很简单
 */
public class BSTMinSumFromRootToLeaf {
    public static void main(String[] args) {
        SolutionBSTMinSumFromRootToLeaf.TreeNode root = new SolutionBSTMinSumFromRootToLeaf.TreeNode(5);
        root.left = new SolutionBSTMinSumFromRootToLeaf.TreeNode(5); root.right=new SolutionBSTMinSumFromRootToLeaf.TreeNode(6);
        root.left.left=new SolutionBSTMinSumFromRootToLeaf.TreeNode(9);root.left.right=new SolutionBSTMinSumFromRootToLeaf.TreeNode(4);
        root.left.right.left=new SolutionBSTMinSumFromRootToLeaf.TreeNode(1);
        root.right.right=new SolutionBSTMinSumFromRootToLeaf.TreeNode(4);
        root.right.right.left=new SolutionBSTMinSumFromRootToLeaf.TreeNode(1);
        root.right.right.right=new SolutionBSTMinSumFromRootToLeaf.TreeNode(2);
        root.right.right.left.left=new SolutionBSTMinSumFromRootToLeaf.TreeNode(3);
        SolutionBSTMinSumFromRootToLeaf s = new SolutionBSTMinSumFromRootToLeaf();
        System.out.println(s.minSumFromRootToLeaf(root));
    }
}

class SolutionBSTMinSumFromRootToLeaf {
    public int minSumFromRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return search(root);
    }
    public int search(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.val;
        return Math.min(search(root.left), search(root.right)) + root.val;
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}