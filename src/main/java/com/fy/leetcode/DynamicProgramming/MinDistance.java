package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname MinDistance
 * @Description TODO
 * @Date 2022/1/9 21:55
 * @Created by fy
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int delete = dp[i - 1][j];
                    int add = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(delete, add), replace) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
