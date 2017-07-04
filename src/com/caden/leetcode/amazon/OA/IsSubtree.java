package com.caden.leetcode.amazon.OA;

/**
 * 有两个不同大小的二进制树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。

 注意事项

 若 T1 中存在从节点 n 开始的子树与 T2 相同，我们称 T2 是 T1 的子树。也就是说，如果在 T1 节点 n 处将树砍断，砍断的部分将与 T2 完全相同。

 您在真实的面试中是否遇到过这个题？ Yes
 样例
 下面的例子中 T2 是 T1 的子树：

         1                3
        / \              /
 T1 = 2   3      T2 =  4
         /
        4
 下面的例子中 T2 不是 T1 的子树：

         1               3
        / \               \
 T1 = 2   3       T2 =    4
          /
         4
 */
public class IsSubtree {
}

class SolutionIsSubtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        if (T1 == null) return false;
        if (T2 == null) return true;

        if (isValid(T1, T2)) return true;
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    private boolean isValid(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        if (T1 == null || T2 == null) return false;

        if (T1.val != T2.val) return false;
        return isValid(T1.left, T2.left) && isValid(T1.right, T2.right);//注意这里是&&而不是||
    }
    class TreeNode {
        int val;
        TreeNode left, right;
    }
}