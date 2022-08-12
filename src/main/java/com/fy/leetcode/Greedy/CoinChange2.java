package com.fy.leetcode.Greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname CoinChange2
 * @Description TODO
 * @Date 2022/3/9 12:53
 * @Created by fy
 */
public class CoinChange2 {
    @Test
    public void test() {
        int[] coins = {1,2,5};
        change(5, coins);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        for(int i = 1; i <= amount; ++i){
            int sum = 0;
            for(int j : coins){
                if(i - j >= 0 && dp[i - j] != -1){
                    sum = sum + dp[i - j];
                }
            }
            if(sum != 0){
                dp[i] = sum;
            }
        }
        return dp[amount] == -1 ? 0 : dp[amount];
    }
}
