package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname ReverseKGroup
 * @Description TODO
 * @Date 2021/8/12 9:11
 * @Created by fy
 */
public class ReverseKGroup {

    @Test
    public void test(){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i=0;i<7;++i){
            ListNode newnode = new ListNode(i+1);
            p.next = newnode;
            p = p.next;
        }
        head = head.next;
        ListNode newhead = reverseKGroup(head, 1);
        ListNode q = newhead;
        while (q != null){
            System.out.println(q.val);
            q= q.next;
        }
    }
    public ListNode reverseKGroup(ListNode head ,int k){
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode p = head;
       ListNode pre = dummy;
       while (p != null){
           ListNode start = p;
           for(int i = 0; i < k - 1; i++){
               if(p.next != null){
                   p = p.next;
               }
           }
           ListNode end = p;
           p = p.next;
           end.next = null;
           ListNode[] newSE = reverse(start, end);
           pre.next = newSE[0];
           pre = newSE[1];
       }
       return dummy.next;
    }

    public ListNode[] reverse(ListNode start,ListNode end){
        ListNode dummy = new ListNode(0);
        ListNode p = start;
        while (p != null){
            ListNode tmp = p;
            p = p.next;
            tmp.next = dummy.next;
            dummy.next = p;
        }
        return new ListNode[]{dummy.next,start};
    }
}
