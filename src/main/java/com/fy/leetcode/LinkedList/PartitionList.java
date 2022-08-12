package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname PartitionList
 * @Description TODO
 * @Date 2022/3/25 13:27
 * @Created by fy
 */
public class PartitionList {

    @Test
    public void test(){
        System.out.println(-1 ^ -1);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val < x){
            pre = pre.next;
        }
        ListNode p_pre = pre;
        ListNode p = pre.next;
        while (p != null){
            if(p.val < x){
                p_pre.next = p.next;
                p.next = pre.next;
                pre.next = p;
                pre = p;
                p = p_pre.next;
            }
            else{
                p_pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
