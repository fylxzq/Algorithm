package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname CanPartition
 * @Description TODO
 * @Date 2022/6/12 9:04
 * @Created by fy
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1]; //dp[i][j]表示0 - i的数字能否构成数字j
        for(int i = 0; i < len; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 0; i < len; i++){
            int num = nums[i];
            for(int j = target; j >= num; j--){
                dp[i][j] |= (dp[i - 1][j] || dp[i - 1][j - num]);
            }
        }
        return dp[len - 1][target];
    }
}
