package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname RotateRight
 * @Description TODO
 * @Date 2022/3/12 12:52
 * @Created by fy
 */
public class RotateRight {
    @Test
    public void test() {
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int count = 0;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        count++;
        p.next = head;
        k = k % count;
        for(int i = 0; i < k; i++){
            p = head;
            head = head.next;
        }
        p.next = null;
        return head;
    }
}
