package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname CircleLinkList
 * @Description TODO
 * @Date 2021/8/28 14:28
 * @Created by fy
 */
public class CircleLinkList {

    public ListNode detectcycle(ListNode head){
       if (head == null || head.next == null){
           return null;
       }
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null){
           slow = slow.next;
           fast = fast.next.next;
           if(fast.next == null){
               return null;
           }
           if(slow == fast){
               fast = head;
               while (slow != fast){
                   slow = slow.next;
                   fast = fast.next;
               }
               return slow;
           }
       }
       return null;
    }
}
