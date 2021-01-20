package com.zhh.algorithm.exercise.list;

/**
 * Leetcode  876. 链表的中间结点
 */
public class MiddleNodeForList {
    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast !=null){
            slow = slow.next;
        }

        return slow;
    }
}
