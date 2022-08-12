package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.LinkListUtil;
import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * @Classname MiddleNode
 * @Description TODO
 * @Date 2022/1/4 19:43
 * @Created by fy
 */
public class MiddleNode {

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        ListNode head = LinkListUtil.createLinkList(nums);
        LinkListUtil.PirntLinkList(head);
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
}
