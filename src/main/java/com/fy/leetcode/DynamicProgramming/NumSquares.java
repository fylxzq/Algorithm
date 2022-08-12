package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname NumSquares
 * @Description TODO
 * @Date 2022/6/17 21:22
 * @Created by fy
 */
public class NumSquares {
    
    public int numSquares(int n) {
        int k = (int) Math.pow(n,0.5);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;
        for(int i = 1; i <= k; i++){
            for(int j = 0; j <= n; j++){
                if(j >= i * i){
                    dp[j] = Math.min(dp[j],dp[j - i * i]);
                }
            }
        }
        return dp[n];
    }
}
