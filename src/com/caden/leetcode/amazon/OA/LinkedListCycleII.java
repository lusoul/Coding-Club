package com.caden.leetcode.amazon.OA;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycleII {
}

class SolutionLinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next, slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        ListNode cur = head;
        while (cur != slow) {
            slow = slow.next;
            cur = cur.next;
        }
        return cur;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}