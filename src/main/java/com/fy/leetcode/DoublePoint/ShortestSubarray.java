package com.fy.leetcode.DoublePoint;

import org.junit.Test;

import javax.print.attribute.standard.OrientationRequested;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname ShortestSubarray
 * @Description TODO
 * @Date 2022/5/16 14:58
 * @Created by fy
 */
public class ShortestSubarray {

    @Test
    public void test(){
        int[] nums = {84,-37,32,40,95};
        System.out.println(shortestSubarray(nums, 167));
    }
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] preSumArr = new long[len + 1];
        long preSum = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] >= k ){
                return 1;
            }
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        int res = len + 1;
        for(int i = 0; i <= len; i++){
            while (!deque.isEmpty() && preSumArr[i] <= preSumArr[deque.peekLast()]){
                deque.pollLast();
            }
            while (!deque.isEmpty() && preSumArr[i] - preSumArr[deque.peekFirst()] >= k){
                res = Math.min(res,i - deque.pollFirst());
            }
            deque.offerLast(i);
        }
        return  res;
    }
}
