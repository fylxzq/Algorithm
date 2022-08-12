package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname MergeTwoList
 * @Description TODO
 * @Date 2021/8/13 15:42
 * @Created by fy
 */
public class MergeTwoList {
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode r = head;
        while (p != null && q != null){
            if(p.val <= q.val){
                r.next = p;
                p = p.next;
                r = r.next;
            }
            else{
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
        if(p!=null){
            r.next = p;
        }
        if(q!=null){
            r.next = q;
        }
        return head.next;
    }
}
