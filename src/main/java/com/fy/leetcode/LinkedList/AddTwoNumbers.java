package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

import java.awt.*;

/**
 * @Classname AddTwoNumbers
 * @Description TODO
 * @Date 2021/7/22 22:04
 * @Created by fy
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);//创建一个头结点更加方便地解决此问题
        ListNode p = head;
        int firstnum = 0;
        int secondnum = 0;
        while (l1 != null && l2 != null){
            int tmpsum = l1.val + l2.val + secondnum;
            firstnum = tmpsum % 10;
            secondnum = tmpsum / 10;//有可能会进1
            //创建一个新节点并连接
            ListNode q = new ListNode(firstnum);
            p.next = q;
            p = q;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int tmpsum = l1.val + secondnum;
            firstnum = tmpsum % 10;
            secondnum = tmpsum / 10;
            ListNode q = new ListNode(firstnum);
            p.next = q;
            p = q;
            l1 = l1.next;
        }
        while (l2 != null){
            int tmpsum = l2.val + secondnum;
            firstnum = tmpsum % 10;
            secondnum = tmpsum / 10;
            ListNode q = new ListNode(firstnum);
            p.next = q;
            p = q;
            l2 = l2.next;
        }
        if (secondnum != 0){
            ListNode q = new ListNode(secondnum);
            p.next = q;
        }
        return head.next;
    }
}



