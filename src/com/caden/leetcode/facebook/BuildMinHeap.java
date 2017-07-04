package com.caden.leetcode.facebook;

import java.util.Deque;
import java.util.LinkedList;

/**
 * input是 个array，要求 成 个树，有以下三个属性
 1) 叉树
 2)Min Heap，表示node的每个 节点的值都 于或者等于这个node的值 3)做inorder traversal的时候要保持array的顺序
 举个  input是 5, 2, 10, 7
    2
   / \
  5   7
     /
    10
 follow up 是 个addNode的函数，输 是root node，还有个int value，保持原有的属 性，返回root
 */
public class BuildMinHeap {
    public static void main(String[] args) {
        BuildMinHeap b = new BuildMinHeap();
        int[] A = {8,2,9,4,3,1,6};
//        TreeNode root = b.build(A);
        TreeNode root = b.myONsolution(A);

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            System.out.println();
        }
    }

    public TreeNode myONsolution(int[] A) {
        TreeNode cur = new TreeNode(A[0]);
        for (int i = 1; i < A.length; i++) {
            TreeNode node = new TreeNode(A[i]);
            if (cur.val > A[i]) {
                node.left = cur;
                cur = node;
            } else {
                if (cur.right == null) cur.right = node;
                else {
                    node.left = cur.right;
                    cur.right = node;
                }
            }
        }
        return cur;
    }

    public TreeNode build(int[] input) {
        return helper(input, 0, input.length - 1);
    }
    public TreeNode helper(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1;
        int val = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (input[i] <= val) {
                index = i;
                val = input[i];
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = helper(input, start, index - 1);
        root.right = helper(input, index + 1, end);
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
