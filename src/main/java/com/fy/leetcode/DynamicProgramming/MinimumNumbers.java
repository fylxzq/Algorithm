package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Classname MinimumNumbers
 * @Description TODO
 * @Date 2022/6/19 11:04
 * @Created by fy
 */
public class MinimumNumbers {
    public int minimumNumbers(int num, int k) {
        int[] dp = new int[num + 1];
        int index = num / 10;
        int extra = num % 10;
        Arrays.fill(dp, num + 1);
        dp[0] = 0;
        int carry= 1;
        for(int i = 0; i <= index; i++){
            int sum = 10 * i + k;
            for(int j = 1; j <= num; j++){
                if(j >= sum){
                    dp[j] = Math.min(dp[j],dp[j - sum] + 1);
                }
            }
        }
        return dp[num] == num + 1 ? -1 : dp[num];
    }
}
