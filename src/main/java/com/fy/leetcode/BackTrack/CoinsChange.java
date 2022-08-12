package com.fy.leetcode.BackTrack;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname CoinsChange
 * @Description TODO
 * @Date 2022/1/21 10:08
 * @Created by fy
 */
public class CoinsChange {
    int rst = Integer.MAX_VALUE;
    @Test
    public void test(){
        int[] coins = new int[]{186,419,83,408};
        coinChange(coins, 6249);
    }

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i){
            for(int j = 0;j < len; ++j){
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public void dfs(int[] nums,int amout,int count){
        if(amout < 0){
            return;
        }
        if(amout == 0){
            rst = Math.min(rst, count);
        }
        for(int i = nums.length -1 ; i >= 0; --i){
            if(rst == Integer.MAX_VALUE){
                dfs(nums, amout-nums[i],count+1);
            }
        }
    }
}
