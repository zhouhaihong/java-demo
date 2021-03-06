package com.zhh.algorithm.exercise.stack;

import com.zhh.algorithm.exercise.list.ListNode;

/**
 * 有关栈的LeetCode题：20,155,232,844,224,682,496.
 */
public class ListStack {
    private ListNode stack;
    private int count;

    public ListStack(){
        stack = new ListNode();
    }

    public boolean push(int ele){
        ListNode node = new ListNode(ele);
        ListNode temp = stack.next;
        stack.next = node;
        node.next = temp;
        count++;
        return true;
    }

    public int poll(){
        if(count == 0){
            return -1;
        }
        ListNode node = stack.next;
        stack = stack.next.next;
        count--;
        return node.val;
    }

}
