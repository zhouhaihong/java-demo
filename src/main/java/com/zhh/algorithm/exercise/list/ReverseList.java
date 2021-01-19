package com.zhh.algorithm.exercise.list;

/**
 * 链表反转：LeedCode 206
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode current = head;

        while (current != null){
            ListNode node = current.next;
            current.next = pre;
            pre = current;
            current = node;
        }

        return pre;
    }

}
