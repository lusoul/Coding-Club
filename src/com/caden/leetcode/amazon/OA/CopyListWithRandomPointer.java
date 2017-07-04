package com.caden.leetcode.amazon.OA;

/**
 * Created by lusoul on 2017/5/8.
 */
public class CopyListWithRandomPointer {
}
class SolutionCopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newP = new RandomListNode(p.label);
            newP.next = p.next;
            p.next = newP;
            p = p.next.next;
        }
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next.next;
            p.next.random = p.random == null ? null : p.random.next;
            p = temp;
        }
        p = head;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            temp.next = p.next == null ? null : p.next.next;
            p = p.next;
        }

        return newHead;
    }
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}