package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname NumDecodings
 * @Description TODO
 * @Date 2022/4/28 13:18
 * @Created by fy
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for(int i = 1; i <= len; i++){
            if(s.charAt(i - 1) == '0'){
                if(i == 1 || s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2'){
                    return 0;
                }
                else {
                    dp[i] = dp[i - 1];
                }
            }
            else{
                dp[i] = dp[i - 1];
                if(i > 1 && s.charAt(i - 2) != '0' &&Integer.parseInt(s.substring(i - 2,i)) <= 26){
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }
}
