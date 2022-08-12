package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname NextGreaterElements
 * @Description TODO
 * @Date 2022/5/12 21:22
 * @Created by fy
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for(int i = 0; i < 2 * len - 1; i++){
            while ( !deque.isEmpty() && nums[i % len] > nums[deque.peek()]){
                res[deque.peek()] = nums[i % len];
            }
            deque.push(i % len);
        }
        return res;
    }
}
