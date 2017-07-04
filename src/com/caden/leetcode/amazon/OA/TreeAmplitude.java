package com.caden.leetcode.amazon.OA;

/**
 * Given a tree of N nodes, return the amplitude of the tree

 就是从 root 到 leaf 的所有路径中，求个 max - min 的差 求个最大值

 直接DFS从上往下走，传递max和min一直到最后空节点的时候，计算一下结果放到全局max中
 */
public class TreeAmplitude {
    public static void main(String[] args) {
        SolutionTreeAmplitude.TreeNode root = new SolutionTreeAmplitude.TreeNode(5);
        SolutionTreeAmplitude.TreeNode n1 = new SolutionTreeAmplitude.TreeNode(8);
        SolutionTreeAmplitude.TreeNode n2 = new SolutionTreeAmplitude.TreeNode(9);
        SolutionTreeAmplitude.TreeNode n3 = new SolutionTreeAmplitude.TreeNode(12);
        SolutionTreeAmplitude.TreeNode n4 = new SolutionTreeAmplitude.TreeNode(2);
        SolutionTreeAmplitude.TreeNode n5 = new SolutionTreeAmplitude.TreeNode(8);
        SolutionTreeAmplitude.TreeNode n6 = new SolutionTreeAmplitude.TreeNode(4);
        SolutionTreeAmplitude.TreeNode n7 = new SolutionTreeAmplitude.TreeNode(2);
        SolutionTreeAmplitude.TreeNode n8 = new SolutionTreeAmplitude.TreeNode(5);
        root.left = n1;root.right=n2;
        n1.left=n3;n1.right=n4;n2.left=n5;n2.right=n6;
        n5.left=n7;n6.left=n8;
        SolutionTreeAmplitude s = new SolutionTreeAmplitude();
        System.out.println(s.amplitude(root));
    }
}

class SolutionTreeAmplitude {
    int ret = Integer.MIN_VALUE;
    public int amplitude(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return ret;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            ret = Math.max(ret, max - min);
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}