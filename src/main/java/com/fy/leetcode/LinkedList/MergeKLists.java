package com.fy.leetcode.LinkedList;

import com.fy.leetcode.Utils.ListNode;

import java.util.PriorityQueue;

/**
 * @Classname MergeKLists
 * @Description TODO
 * @Date 2021/12/27 12:38
 * @Created by fy
 */
public class MergeKLists {

    public ListNode mergeKlist(ListNode[] lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((l1, l2) ->{
            return Integer.compare(l1.val,l2.val);
        });
        if(lists == null || lists.length < 1){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode p = lists[0];
        if(p != null){
            ListNode tmp = p;
            priorityQueue.add(tmp);
            p = p.next;
            tmp.next = null;
            lists[0] = p;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while ( !priorityQueue.isEmpty() ){
            for(int i = 0; i < lists.length; i++){
                ListNode list = lists[i];
                if(list != null){
                    ListNode tmp = list;
                    list = list.next;
                    tmp.next = null;
                    priorityQueue.add(tmp);
                    lists[i] = list;
                }
            }
            pre.next = priorityQueue.poll();
            pre = pre.next;
        }
        return dummy.next;
    }

}
