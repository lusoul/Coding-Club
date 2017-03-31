package com.caden.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayToBalancedBinaryTree {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        ArrayToBalancedBinaryTree ab = new ArrayToBalancedBinaryTree();
        TreeNode root = ab.generatePreorder(A);
        printOutTree(root);
    }

//    int prePoint = 0;
    public TreeNode generatePreorder(int[] A) {
        int[] idx = {0};
        TreeNode ret = preDfs(A, 0, A.length - 1, idx);
        System.out.println("hello");
        return ret;
    }
    private TreeNode preDfs(int[] A, int start, int end, int[] idx) {
        if (start > end) return null;
        // pre order
        TreeNode root = new TreeNode(A[idx[0]]);
        idx[0]++;

        int mid = (start + end) / 2;
        TreeNode left = preDfs(A, start, mid - 1, idx);
        // in order
//        TreeNode root = new TreeNode(A[prePoint]);
//        prePoint++;
        TreeNode right = preDfs(A, mid + 1, end, idx);
        // post order
//        TreeNode root = new TreeNode(A[prePoint]);
//        prePoint++;
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

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
