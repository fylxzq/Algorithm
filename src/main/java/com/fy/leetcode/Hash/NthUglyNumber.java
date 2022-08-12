package com.fy.leetcode.Hash;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Classname NthUglyNumber
 * @Description TODO
 * @Date 2022/8/8 16:58
 * @Created by fy
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        priorityQueue.add(1);
        set.add(1);
        int res = 1;
        for(int i = 1; i <= n; i++){
            res = priorityQueue.poll();
            int val2 = res * 2;
            int val3 = res * 3;
            int val5 = res * 5;
            if(set.add(val2)){
                priorityQueue.add(val2);
            }
            if(set.add(val3)){
                priorityQueue.add(val3);
            }
            if(set.add(val5)){
                priorityQueue.add(val5);
            }
        }
        return res;
    }
}
