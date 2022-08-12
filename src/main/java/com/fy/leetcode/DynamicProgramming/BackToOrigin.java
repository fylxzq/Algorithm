package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname BackToOrigin
 * @Description TODO
 * @Date 2022/8/1 19:56
 * @Created by fy
 */
public class BackToOrigin {
    public int backToOrigin(int n,int m){
        int[][] dp = new int[n + 1][m];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = dp[i - 1][(j + 1) % m] + dp[i - 1][(j - 1 + m) % m];
            }
        }
        return dp[n][0];
    }
}
