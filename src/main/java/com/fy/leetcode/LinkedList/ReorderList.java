package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.LinkListUtil;
import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname ReorderList
 * @Description TODO
 * @Date 2022/1/4 11:34
 * @Created by fy
 */
public class ReorderList {
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        ListNode head = LinkListUtil.createLinkList(nums);
        LinkListUtil.PirntLinkList(head);
        System.out.println(ReorderList.class.getClassLoader());

    }
    public void reorderList(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode newright = reverlist(right);
        ListNode p = head;
        ListNode q = newright;
        ListNode r;
        while (q != null){
            r = p;
            p = p.next;
            r.next = q;
            r = q;
            q = q.next;
            r.next = p;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if(fast.next != null){
                fast= fast.next.next;
            }
            else{
                break;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverlist(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverlist(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;

    }
}
