package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Classname Respace
 * @Description TODO
 * @Date 2022/7/6 19:38
 * @Created by fy
 */
public class Respace {
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[sentence.length() + 1];
        for(int i = 1; i <= len; i++){
            dp[i] = dp[i - 1] + 1;
            for(String word : dictionary){
                int wordLen = word.length();
                if(i >= wordLen && sentence.substring(i - wordLen, i).equals(word)){
                    dp[i] = Math.min(dp[i],dp[i - wordLen]);
                }
            }
        }
        return dp[len];
    }
}
