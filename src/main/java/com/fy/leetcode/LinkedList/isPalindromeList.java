package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.LinkListUtil;
import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname isPalindromeList
 * @Description TODO
 * @Date 2022/1/20 22:28
 * @Created by fy
 */
public class isPalindromeList {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,2,1};
        ListNode head = LinkListUtil.createLinkList(nums);
        LinkListUtil.PirntLinkList(reverseList(head));
    }


    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode newHead = middle.next;
        middle.next = null;
        ListNode  Righthead = reverseList(newHead);
        ListNode p = head;
        ListNode q = Righthead;
        while (p != null && q!= null){
            if(p.val != q.val){
                return false;
            }
        }
        newHead = reverseList(Righthead);
        middle.next = newHead;
        return true;
    }
    public ListNode reverseList(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    public ListNode getMiddle(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast  = dummy;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * @Classname Multiply
     * @Description TODO
     * @Date 2022/1/21 8:34
     * @Created by fy
     */

}
