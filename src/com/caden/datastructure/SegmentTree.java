package com.caden.datastructure;

public class SegmentTree {
    class TreeNode {
        TreeNode left, right;
        int start, end, sum;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public TreeNode buildTree(int[] A, int start, int end) {
        if (A == null || A.length == 0 || start > end) return null;
        if (start == end) {
            TreeNode node = new TreeNode(start, end);
            node.sum = A[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(start, end);
        root.left = buildTree(A, start, mid);
        root.right = buildTree(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    public int query(TreeNode root, int start, int end) {
        if (root == null || start > root.end || end < root.start) return 0;
        if (start <= root.start && end >= root.end) return root.sum;
        return query(root.left, start, end) + query(root.right, start, end);
    }
    public void modify(TreeNode root, int idx, int val) {
        if (root == null || idx > root.end || idx < root.start) return;
        if (idx == root.start && idx == root.end) {
            root.sum = val;
            return;
        }
        modify(root.left, idx, val);
        modify(root.right, idx, val);
        root.sum = root.left.sum + root.right.sum;
    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();
        int[] A = {1,2,3,4,5,6,7,8,9};
        TreeNode root = st.buildTree(A, 0, A.length - 1);
        System.out.println(st.query(root, -1,4));
        st.modify(root, 0, 2);
        System.out.println(st.query(root, 0, 2));
    }
}
