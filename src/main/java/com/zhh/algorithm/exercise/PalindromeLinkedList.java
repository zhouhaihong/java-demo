package com.zhh.algorithm.exercise;


/**
 * 给定一个单链表，判断其是否是回文字符串
 * 解题思路：使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
 * 注意点：
 *  1.快慢指针遍历的终止条件（前半部分链表反序）
 *  2.链表元素个数为偶数的特殊处理
 */
public class PalindromeLinkedList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        // 关键点找到指针移动的终止条件，根据链表元素奇偶情况
        // 需要将链表反序
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            ListNode node = slow.next;
            slow.next = pre;
            pre = slow;
            slow = node;
        }

        // 针对链表元素为偶数的情况进行处理
        if(fast != null){
            slow = slow.next;
        }

        // 从中间依次遍历比较元素是否相同
        while (slow != null){
            if(slow.val != pre.val){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }

}
