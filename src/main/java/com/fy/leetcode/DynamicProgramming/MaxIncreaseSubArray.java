package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @Classname MaxIncreaseSubArray
 * @Description TODO
 * @Date 2022/1/2 12:01
 * @Created by fy
 */
public class MaxIncreaseSubArray {

    @Test
    public void test(){
        int[] nums =  {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int rst = 0;
        for(int num : nums){
            int i = 0,j = rst;
            while (i < j){
                int m = (i + j) / 2;
                if(dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if(rst == j){
                rst ++;
            }
        }
        return rst;
    }
}
