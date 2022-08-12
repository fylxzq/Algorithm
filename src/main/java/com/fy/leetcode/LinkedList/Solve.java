package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.LinkListUtil;
import com.fy.leetcode.Utils.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @Classname Solve
 * @Description TODO
 * @Date 2022/4/24 21:42
 * @Created by fy
 */
public class Solve {
    @Test
    public void test(){
    }
    public ListNode solve (ListNode[] a) {
        // write code here
        Set<Integer> set = new HashSet<>();
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode head = a[0];
        int minVal = Integer.MAX_VALUE;
        while (!set.contains(head.val)){
            set.add(head.val);
            minVal = Math.min(minVal, head.val);
            map.put(head.val, head);
            head = head.next;
        }
        map.get(minVal).next = null;
        return map.get(minVal);
    }
}
