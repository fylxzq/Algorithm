package com.fy.leetcode.Recursion;

/**
 * @Classname MaxProduct
 * @Description TODO
 * @Date 2022/4/16 15:06
 * @Created by fy
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int maxF = nums[0];
        int minF = nums[0];
        int res = maxF;
        for(int i = 0; i < len; i++){
            int val1 = nums[i] * maxF;
            int val2 = nums[i] * minF;
            maxF = Math.max(nums[i], Math.max(val1, val2));
            minF = Math.max(nums[i], Math.min(val1, val2));
            res = Math.max(res, maxF);
        }
        return maxF;
    }
}
