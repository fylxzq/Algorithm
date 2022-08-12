package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname RemoveNthFromEnd
 * @Description TODO
 * @Date 2022/1/7 22:05
 * @Created by fy
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode p = head;
        ListNode q = head;
        int i = 1;
        while (q.next != null ){
            if(i != n){
                q = q.next;
                ++i;
            }
            else{
                q = q.next;
                p = p.next;
                front = front.next;
            }
        }
        front.next = p.next;
        return dummy.next;
    }
}
