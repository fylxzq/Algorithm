package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname maxSubArray
 * @Description TODO
 * @Date 2021/12/21 22:36
 * @Created by fy
 */
public class maxSubArray {

    public int maxSubArray(int[] nums){
        int pre = 0,rst = nums[0];
        for(int num:nums){
            pre = Math.max(num, pre+num);
            rst = Math.max(pre, rst);
        }
        return rst;
    }
}
