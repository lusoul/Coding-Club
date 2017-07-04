package com.caden.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListToBalancedBinaryTree {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);ListNode n2 = new ListNode(2);ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);ListNode n5 = new ListNode(5);
        n1.next = n2;n2.next=n3;n3.next=n4;n4.next=n5;

        LinkedListToBalancedBinaryTree lb = new LinkedListToBalancedBinaryTree();
        TreeNode root = lb.generateOrder(n1);
        printOutTree(root);
    }

//    ListNode curr;
    public TreeNode generateOrder(ListNode head) {
        ListNode curr = head;
        TreeNode ret = dfs(0, 4, curr);
        return ret;
    }
    private TreeNode dfs(int start, int end, ListNode curr) {
        if (start > end) return null;

        TreeNode node = new TreeNode(curr.val);
        curr = curr.next;//这句要求curPoint必须是全局变量，如果只是方法参数，该方法内修改了引用指向，方法外并没有变，除非你改变的是引用内的值

        int mid = (start + end) / 2;
        TreeNode left = dfs(start, mid - 1, curr);
        TreeNode right = dfs(mid + 1, end, curr);

        node.left = left;
        node.right = right;
        return node;
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
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

}