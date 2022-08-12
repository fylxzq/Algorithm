package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;


/**
 * @Classname ReverseBetween
 * @Description TODO
 * @Date 2021/12/24 17:50
 * @Created by fy
 */
public class ReverseBetween {

    @Test
    public void test(){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 1;i <=5 ;++i){
            ListNode tmpnode = new ListNode(i);
            p.next = tmpnode;
            p = p.next;
        }
        head = head.next;
        ListNode rst = reverseBetween(head, 2, 4);
        while (rst !=null){
            System.out.println(rst.val);
            rst = rst.next;
        }
    }


    public ListNode reverseBetween(ListNode head, int left ,int right){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0 ; i < left - 1; ++ left){
            pre = pre.next;
        }
        ListNode leftnode = pre.next;
        ListNode rightnode = leftnode;
        for(int i = 0; i < right - left; ++i){
            rightnode = rightnode.next;
        }
        pre.next = null;
        ListNode afterright = rightnode.next;
        rightnode.next = null;
        reverseList(leftnode);
        leftnode.next = afterright;
        pre.next = rightnode;
        return dummy.next;
    }

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
