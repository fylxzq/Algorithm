package com.fy.leetcode.SlidingWindow;

import org.junit.Test;

import java.util.*;

/**
 * @Classname MaxSlidingWindow
 * @Description TODO
 * @Date 2022/1/17 12:51
 * @Created by fy
 */
public class MaxSlidingWindow {
    @Test
    public void test(){
       int[] nums = new int[]{7,2,4};
       maxSlidingWindow(nums, 2);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> deque = new LinkedList<>();
       int len = nums.length;
       int[] res = new int[len - k + 1];
       int count = 0;
       for(int i = 0; i < nums.length; i++){
           if(deque.isEmpty() || nums[i] <= nums[deque.peekLast()]){
               deque.offerLast(i);
           }
           else{
               while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                   deque.pollLast();
               }
               deque.offerLast(i);
           }
           if(i >= k - 1){
                while (i - deque.peekFirst() + 1 > k){
                    deque.pollFirst();
                }
                res[count] = nums[deque.peekFirst()];
           }
       }
       return res;
    }
}
