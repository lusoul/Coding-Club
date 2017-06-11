package com.caden.leetcode.amazon.OA;

import java.util.ArrayList;
import java.util.List;

/**
 * 就是给一棵多叉树，表示公司内部的上下级关系。每个节点表示一个员工，节点包含的成员是他工作了几个月(int)，以及一个下属数组(ArrayList<Node>)。
 目标就是找到一棵子树，满足：这棵子树所有节点的工作月数的平均数是所有子树中最大的。最后返回这棵子树的根节点。这题补充一点，
 返回的不能是叶子节点(因为叶子节点没有下属)，一定要是一个有子节点的节点。
 class Node {
 int val;
 ArrayList<Node> children;
 }

 然后函数是传入一整棵树的根节点，输出符合要求的子树根节点。
 例：
      1
  ／    |     \
  2     3      4
 /\    /\     /\
 5 5  5  5   5  5
 子树有以1为根，2为根，3为根，4为根的子树。假设1为根的子树所有工作月份相加为40，总共有10个节点，所以平均数就是40/10=4；
 */
public class CompanyTree {
    public static void main(String[] args) {
        SolutionCompanyTree s = new SolutionCompanyTree();
        SolutionCompanyTree.TreeNode root = new SolutionCompanyTree.TreeNode(8);

        SolutionCompanyTree.TreeNode n1 = new SolutionCompanyTree.TreeNode(9);
        SolutionCompanyTree.TreeNode n2 = new SolutionCompanyTree.TreeNode(4);
        SolutionCompanyTree.TreeNode n3 = new SolutionCompanyTree.TreeNode(5);
        SolutionCompanyTree.TreeNode n4 = new SolutionCompanyTree.TreeNode(5);

        SolutionCompanyTree.TreeNode n5 = new SolutionCompanyTree.TreeNode(2);
        SolutionCompanyTree.TreeNode n6 = new SolutionCompanyTree.TreeNode(8);
        SolutionCompanyTree.TreeNode n7 = new SolutionCompanyTree.TreeNode(2);
        SolutionCompanyTree.TreeNode n8 = new SolutionCompanyTree.TreeNode(7);
        SolutionCompanyTree.TreeNode n9 = new SolutionCompanyTree.TreeNode(2);
        SolutionCompanyTree.TreeNode n10 = new SolutionCompanyTree.TreeNode(3);
        SolutionCompanyTree.TreeNode n11 = new SolutionCompanyTree.TreeNode(5);

        SolutionCompanyTree.TreeNode n12 = new SolutionCompanyTree.TreeNode(4);
        SolutionCompanyTree.TreeNode n13 = new SolutionCompanyTree.TreeNode(9);
        SolutionCompanyTree.TreeNode n14 = new SolutionCompanyTree.TreeNode(6);
        SolutionCompanyTree.TreeNode n15 = new SolutionCompanyTree.TreeNode(1);

        root.kids.add(n1);root.kids.add(n2);root.kids.add(n3);root.kids.add(n4);
        n1.kids.add(n5);n1.kids.add(n6);
        n2.kids.add(n7);
        n3.kids.add(n8);n3.kids.add(n9);n3.kids.add(n10);n3.kids.add(n11);
        n7.kids.add(n12);n7.kids.add(n13);
        n9.kids.add(n14);n9.kids.add(n15);


        System.out.println(s.companyTree(root).val);
    }
}

class SolutionCompanyTree {
    public TreeNode companyTree(TreeNode root) {
        if (root == null || root.kids == null || root.kids.size() == 0) return null;
        search(root);
        return retNode;
    }

    double max = Double.MIN_VALUE;
    TreeNode retNode = null; //最终返回的结果
    private ResultType search(TreeNode root) {
        if (root.kids == null || root.kids.size() == 0) {
            return new ResultType(1, root.val);
        }

        List<TreeNode> kids = root.kids;
        int count = 1, sum = root.val;
        for (int i = 0; i < kids.size(); i++) {
            ResultType rt = search(kids.get(i));
            count += rt.nodeCount;
            sum += rt.sum;
        }
        if (max < (double)sum / count) {
            max = (double)sum / count;
            retNode = root;
        }
        return new ResultType(count, sum);
    }

    class ResultType {
        int nodeCount;//节点个数
        int sum;//所有月份和
        public ResultType(int nodeCount, int sum) {
            this.nodeCount = nodeCount;
            this.sum = sum;
        }
    }

    static class TreeNode {
        int val;
        List<TreeNode> kids;
        public TreeNode(int val) {
            this.val = val;
            kids = new ArrayList<>();
        }
    }
}