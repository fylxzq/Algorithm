package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname GetKthFromEnd
 * @Description TODO
 * @Date 2022/1/4 22:49
 * @Created by fy
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int i = 1;
        ListNode p = head;
        ListNode q = head;
        while (q.next != null){
            if(i != k){
                q = q.next;
            }
            else{
                p = p.next;
                q = q.next;
            }
        }
        return p;
    }
}
