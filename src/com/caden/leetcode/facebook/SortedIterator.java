package com.caden.leetcode.facebook;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 */
public class SortedIterator {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);ListNode headA2 = new ListNode(5);ListNode headA3 = new ListNode(8);
        headA.next = headA2; headA2.next = headA3;
        ListNode headB = new ListNode(6);ListNode headB2 = new ListNode(16);
        headB.next = headB2;
        Iterator<Integer> listNodeIteratorA = new ListNodeIterator(headA);
        Iterator<Integer> listNodeIteratorB = new ListNodeIterator(headB);

        SortedIterator ite = new SortedIterator(listNodeIteratorA, listNodeIteratorB);
        while (ite.hasNext()) {
            System.out.print(ite.next() + " ");
        }
    }

    MyIterator iterA;
    MyIterator iterB;
    public SortedIterator(Iterator<Integer> A, Iterator<Integer> B) {
        iterA = new MyIterator(A);
        iterB = new MyIterator(B);
    }
    public boolean hasNext() {
        return iterA.hasNext() || iterB.hasNext();
    }
    public Integer next() {
        if (!iterA.hasNext() && !iterB.hasNext()) return null;
        if (!iterA.hasNext()) {
            int ret = iterB.next();
            iterB.val = null;
            return ret;
        }
        if (!iterB.hasNext()) {
            int ret = iterA.next();
            iterA.val = null;
            return ret;
        }
        int a = iterA.next();
        int b = iterB.next();
        if (a < b) {
            iterA.val = null;
            return a;
        } else {
            iterB.val = null;
            return b;
        }
    }
}

class MyIterator {
    Integer val;
    Iterator<Integer> iter;
    public MyIterator(Iterator<Integer> iter) {
        val = null;
        this.iter = iter;
    }
    public boolean hasNext() {
        if (val != null) return true;
        return iter.hasNext();
    }
    public Integer next() {
        if (!hasNext()) return null;
        if (val == null) {
            val = iter.next();
            return val;
        }
        return val;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
class ListNodeIterator implements Iterator<Integer> {
    ListNode head;
    public ListNodeIterator(ListNode head) {
        this.head = head;
    }
    @Override
    public boolean hasNext() {
        if (head == null) {
            return false;
        }
        return true;
    }

    @Override
    public Integer next() {
        Integer ret = head.val;
        head = head.next;
        return ret;
    }
}
