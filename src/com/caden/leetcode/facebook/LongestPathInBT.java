package com.caden.leetcode.facebook;

public class LongestPathInBT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class ResultType {
        int root2any;
        int any2any;

        public ResultType(int root2any, int any2any) {
            this.root2any = root2any;
            this.any2any = any2any;
        }
    }

     public static int maxPathSum(TreeNode root) {
        ResultType ret = search(root);
        return ret.any2any;
    }

    private static ResultType search(TreeNode root) {
        if (root == null) return new ResultType(0, 0);
        if (root.left == null && root.right == null) return new ResultType(1, 1);

        ResultType left = search(root.left);
        ResultType right = search(root.right);
        int rootToAny = Math.max(left.root2any, right.root2any) + 1;
        int anyToAny = Math.max(Math.max(left.any2any, right.any2any), left.root2any + right.root2any + 1);
        return new ResultType(rootToAny, anyToAny);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;n2.left=n4;n2.right=n5;n5.left=n7;n5.right=n8;n4.left=n3;

        System.out.println(maxPathSum(n1));
    }
}
