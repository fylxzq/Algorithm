package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname DeleteDulicates
 * @Description TODO
 * @Date 2022/1/9 22:20
 * @Created by fy
 */
public class DeleteDulicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummpy = new ListNode(-1);
        ListNode p = dummpy;
        ListNode q = head;
        ListNode r = head.next;
        boolean flag = true;
        while (r != null){
            if(r.val != q.val){
                if(flag){
                    p.next = q;
                    p = p.next;
                }
                q = r;
                r = r.next;
                flag = true;
            }
            else{
                r = r.next;
                flag = false;
            }
        }
        if(flag){
            p.next = q;
        }
        return dummpy.next;
    }
}
