package com.fy.leetcode.Utils;/**
 * @Classname LinkListUtil
 * @Description TODO
 * @Date 2022/1/4 19:45
 * @Created by fy
 */public class LinkListUtil {

     public static ListNode createLinkList(int[] nums){
         ListNode dummy = new ListNode(-1);
         ListNode p = dummy;
         for(int num : nums){
             ListNode tmpnode = new ListNode(num);
             p.next = tmpnode;
             p = tmpnode;
         }
         return dummy.next;
     }

     public static void PirntLinkList(ListNode head){
         while (head != null){
             System.out.print(head.val + "\t");
             head = head.next;
         }
     }
}


