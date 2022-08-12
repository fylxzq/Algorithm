package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname ClimbStairs
 * @Description TODO
 * @Date 2022/1/3 22:18
 * @Created by fy
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        else{
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i < n + 1; ++i){
                dp[i] = dp[i- 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
