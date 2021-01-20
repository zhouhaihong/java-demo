package com.zhh.algorithm.exercise.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 链表中环的检测：141
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasCycle {

    /**
     * hash表实现
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针实现
     * 我们定义两个指针，一快一满。慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next(避免一开始就退出while循环)。
     * 这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表
     *
     *
     */
    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next ==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }

        return true;
    }
}
