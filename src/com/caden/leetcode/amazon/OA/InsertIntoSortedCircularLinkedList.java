package com.caden.leetcode.amazon.OA;

/**
 Given a node from a cyclic linked list which has been sorted, write a function to insert a
 value into the list such that it remains a cyclic sorted list. The given node can be any single node
 in the list. Return the inserted new node.

 Notice

 3->5->1 is a cyclic list, so 3 is next node of 1.
 3->5->1 is same with 5->1->3

 Have you met this question in a real interview? Yes
 Example
 Given a list, and insert a value 4:
 3->5->1
 Return 5->1->3->4
 */
public class InsertIntoSortedCircularLinkedList {
}

/* 注意case：
    case 1: 如果head为null，直接返回新建的节点并且让新节点指向自己
    case 2: 新节点在两个节点之间
    case 3: 新节点是最大值或者最小值
    case 4: 链表所有值都是duplicate的所以while循环要有退出条件
 */
class SolutionInsertIntoSortedCircularLinkedList {
    public class Solution {
        public ListNode insert(ListNode head, int val) {
            if (head == null) {
                ListNode node =  new ListNode(val);
                node.next = node;
                return node;
            }

            ListNode curr = head.next;//注意这里，为了防止第一次while不跑
            while (curr != head) {//可能链表全是duplicate就会一直循环，所以要退出条件回到起始点的时候
                //case 1
                //Insert between prev and current.
                if (val >= curr.val && val <= curr.next.val) break;
                    //case 2
                    //x is the maximum or minimum value in the list:
                    //Insert before the head. (ie, the head has the smallest value and its prev→val > head→val.
                else if (curr.val > curr.next.val && (val > curr.val || val < curr.next.val)) break;
                curr = curr.next;
            }

            ListNode node = new ListNode(val);
            node.next = curr.next;
            curr.next = node;
            return node;
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

