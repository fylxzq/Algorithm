package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname InterseectionNode
 * @Description TODO
 * @Date 2021/8/16 11:14
 * @Created by fy
 */
public class InterseectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode PA = headA;
        ListNode PB = headB;
        while (PA != PB){
            PA = PA == null ? headB:PA.next;
            PB = PB == null ? headA:PB.next;
        }
        return PB;
    }
}
