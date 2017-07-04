package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> root2anyPath = new ArrayList<>();
        List<Integer> any2anyPath = new ArrayList<>();
        public ResultType(int root2any, int any2any) {
            this.root2any = root2any;
            this.any2any = any2any;
        }
    }

     public static int maxPathSum(TreeNode root) {
        ResultType ret = search(root);
        List<Integer> path1 = ret.any2anyPath;
        List<Integer> path2 = ret.root2anyPath;
        for (Integer i : path1) System.out.print(i + " ");
        System.out.println();
        for (Integer i : path2) System.out.print(i + " ");
         System.out.println();
        return ret.any2any;
    }
//
//    private static ResultType search(TreeNode root) {
//        if (root == null) return new ResultType(0, 0);
//        if (root.left == null && root.right == null) return new ResultType(1, 1);
//
//        ResultType left = search(root.left);
//        ResultType right = search(root.right);
//        int rootToAny = Math.max(left.root2any, right.root2any) + 1;
//        int anyToAny = Math.max(Math.max(left.any2any, right.any2any), left.root2any + right.root2any + 1);
//        return new ResultType(rootToAny, anyToAny);
//    }

    //follow up: 求出路径
    public static ResultType search(TreeNode root) {
        if (root == null) return new ResultType(0, 0);
        if (root.left == null && root.right == null) {
            ResultType ret = new ResultType(1, 1);
            ret.root2anyPath.add(root.val);
            ret.any2anyPath.add(root.val);
            return ret;
        }

        ResultType left = search(root.left);
        ResultType right = search(root.right);
        int root2any = Math.max(left.root2any, right.root2any) + 1;
        int any2any = Math.max(Math.max(left.any2any, right.any2any), left.root2any + right.root2any + 1);
        ResultType ret = new ResultType(root2any, any2any);


        if (left.root2any > right.root2any) {
            ret.root2anyPath.addAll(left.root2anyPath);
            ret.root2anyPath.add(root.val);
        } else {
            ret.root2anyPath.add(root.val);
            ret.root2anyPath.addAll(right.root2anyPath);
        }

        if (left.any2any > right.any2any) {
            if (left.any2any > left.root2any + right.root2any + 1) {
                ret.any2anyPath.addAll(left.any2anyPath);
            } else {
                ret.any2anyPath.addAll(left.root2anyPath);
                ret.any2anyPath.add(root.val);
                ret.any2anyPath.addAll(right.root2anyPath);
            }
        } else {
            if (right.any2any > left.root2any + right.root2any + 1) {
                ret.any2anyPath.addAll(right.any2anyPath);
            } else {
                ret.any2anyPath.addAll(left.root2anyPath);
                ret.any2anyPath.add(root.val);
                ret.any2anyPath.addAll(right.root2anyPath);
            }
        }
        return ret;
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
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.left = n2;n2.left=n4;n2.right=n5;n5.left=n7;n5.right=n8;n4.left=n3;
        n1.right = n6;
        n8.left = n10;
        n8.right = n9;

        System.out.println(maxPathSum(n1));
    }
}
