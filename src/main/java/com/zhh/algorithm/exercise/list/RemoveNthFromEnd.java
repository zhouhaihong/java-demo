package com.zhh.algorithm.exercise.list;

import java.util.List;

/**
 * Leedcode 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

    /**
     * 计算链表长度遍历法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
       ListNode dump = new ListNode();
       dump.next = head;
       int i = 1;
       int len = getLength(head);
       ListNode temp = dump;
       while (i < (len - n + 1)){
           temp = temp.next;
       }
       temp.next = temp.next.next;
       return dump.next;
    }

    private int getLength(ListNode head){
        int len = 0;
        while (head != null){
            head = head.next;
        }
        return len;
    }

    /**
     * 栈
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        return null;
    }

    /**
     * 一次遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {

        return null;
    }






}
