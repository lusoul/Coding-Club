package com.caden.leetcode.amazon.OA;

/**
 * 把链表后半段反转即可
 */
public class ReverseSecondHalfOfLinkedList {
    public static void main(String[] args) {
        SolutionReverseSecondHalfOfLinkedList.ListNode head = new SolutionReverseSecondHalfOfLinkedList.ListNode(0);
        head.next = new SolutionReverseSecondHalfOfLinkedList.ListNode(1);
        head.next.next = new SolutionReverseSecondHalfOfLinkedList.ListNode(2);
        head.next.next.next = new SolutionReverseSecondHalfOfLinkedList.ListNode(3);
        head.next.next.next.next = new SolutionReverseSecondHalfOfLinkedList.ListNode(4);
        SolutionReverseSecondHalfOfLinkedList s = new SolutionReverseSecondHalfOfLinkedList();
        s.reverse(head);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}

class SolutionReverseSecondHalfOfLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = slow;
        ListNode cur = slow.next;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        tail.next = prev;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}