package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname SortList
 * @Description TODO
 * @Date 2022/1/10 16:55
 * @Created by fy
 */
public class SortList {
    public ListNode sortList(ListNode head) {
       if(head == null){
           return null;
       }
       ListNode mid = getMid(head);
       if(mid.next == null){
           return mid;
       }
       ListNode headB = mid.next;
       mid.next = null;
       return mergeTwoList(sortList(head), headB);
    }

    public ListNode getMid(ListNode head){
        ListNode dummy =new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                r.next = l1;
                l1 = l1.next;
                r = r.next;
            }
            else{
                r.next = l2;
                l2 = l2.next;
                r = r.next;
            }
        }
        if(l1.next != null){
            r.next = l1;
        }
        if(l2.next != null){
            r.next = l2;
        }
        return dummy.next;
    }

}
