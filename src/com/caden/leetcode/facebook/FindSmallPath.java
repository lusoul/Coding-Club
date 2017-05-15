package com.caden.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 给个Tree不一定是平衡的， 要求把所有路径排序后，按字符串比较方法法，找出最小的路径，时间要求线性的。  如
       5
    /    \
  10     3
 /  \    /
 1  7   8
 径有 5 10 1 ; 5 10 7 ; 5 3 8 排序后 1 5 10 ; 5 7 10 ; 3 5 8;
 按字符 那样的 较
 所以按字符 类型排序 为 1 5 10<3 5 8<5 7 10;
 */
public class FindSmallPath {
    public static void main(String[] args) {
        SolutionFindSmallPath s = new SolutionFindSmallPath();
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(10);TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(1);TreeNode n4 = new TreeNode(7);TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(1);
        root.left = n1;root.right = n2;n1.left=n3;n1.right=n4;n2.left=n5;n2.right=n6;
        List<Integer> ret = s.find(root);
        for (Integer i : ret) {
            System.out.print(i + " ");
        }
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
class SolutionFindSmallPath {

    public List<Integer> find(TreeNode root) {
        Result result = helper(root);
        return result.path;
    }
    private Result helper(TreeNode root) {
        if (root == null) {
            Result result = new Result();
            result.path.add(Integer.MAX_VALUE);
            return result;
        }
        if (root.left == null && root.right == null) {
            Result result = new Result();
            result.min = root.val;
            result.path.add(root.val);
            return result;
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result result = new Result();
        result.path.add(root.val);
        if (left.min > right.min) {
            result.path.addAll(right.path);
        }
        else {
            result.path.addAll(left.path);
        }
        result.min = Math.min(root.val, Math.min(left.min,
                right.min));
        return result;
    }
    class Result {
        public int min = Integer.MAX_VALUE;
        public List<Integer> path = new ArrayList<>();
        public Result() {
        }
    }
}


