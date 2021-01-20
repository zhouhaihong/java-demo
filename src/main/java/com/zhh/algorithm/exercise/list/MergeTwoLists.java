package com.zhh.algorithm.exercise.list;

/**
 * 两个有序的链表合并 LeedCode 21
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    /**
     * 递归法
     * 1.找到递推公式：每次用最小元素与剩下的元素进行merge操作
     * 2.找到递归终止条件：两个链表只要有一个为null则，递归结束
     * 3.将递推公司翻译成代码
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代法: 利用哨兵节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode age = new ListNode(0);
        ListNode pre = age;

        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if(l1!=null){
            pre.next = l1;
        }else {
            pre.next = l2;
        }

        return age.next;
    }
}
