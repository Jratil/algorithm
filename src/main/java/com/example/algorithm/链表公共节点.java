package com.example.algorithm;

import org.junit.Test;

/**
 * @author wen
 * @date 2019-08-27 14:42
 */
public class 链表公共节点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void main() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        node4.next = node5;
        node5.next = node6;
        System.out.println(FindFirstCommonNode(node1, node2).val);
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = 0;
        int l2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != null) {
            p1 = p1.next;
            l1++;
        }

        while (p2 != null) {
            p2 = p2.next;
            l2++;
        }
        ListNode result = null;
        if(l1 > l2) {
            result = find(pHead1, pHead2, l1 - l2);
        } else {
            result = find(pHead2, pHead1, l2 - l1);
        }
        return result;
    }

    public ListNode find(ListNode p1, ListNode p2, int step) {
        for (int i = 0; i < step; i++) {
            p1 = p1.next;
        }
        while (p1 != null && p2!= null) {
            if(p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
