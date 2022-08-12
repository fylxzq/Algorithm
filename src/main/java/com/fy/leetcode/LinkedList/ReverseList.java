package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname ReverseList
 * @Description TODO
 * @Date 2021/8/7 16:17
 * @Created by fy
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head  == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
}
