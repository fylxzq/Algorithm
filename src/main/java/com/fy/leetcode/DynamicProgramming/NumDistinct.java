package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname NumDistinct
 * @Description TODO
 * @Date 2022/6/9 9:45
 * @Created by fy
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int i = 0; i <= sLen; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= tLen; j++){
                if(s.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
