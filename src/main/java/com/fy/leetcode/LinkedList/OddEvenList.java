package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

/**
 * @Classname OddEvenList
 * @Description TODO
 * @Date 2022/4/26 20:59
 * @Created by fy
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode p = oddDummy;
        ListNode q = evenDummy;
        ListNode r = head;
        int count = 1;
        while (r != null){
            if(count % 2 == 1){
                ListNode tmp = r;
                r = r.next;
                tmp.next = null;
                p.next = tmp;
                p = p.next;
            }
            else{
                ListNode tmp = r;
                r = r.next;
                tmp.next = null;
                q.next = tmp;
                q = p.next;
            }
            ++count;
        }
        p.next = evenDummy.next;
        return oddDummy.next;
    }
}
