package com.fy.leetcode.DynamicProgramming;


/**
 * @Classname CoinsChange2
 * @Description TODO
 * @Date 2022/4/21 11:33
 * @Created by fy
 */
public class CoinsChange2 {
    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1; i <= amount; i++){
                if(i >= coin){
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
