package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

/**
 * @Classname CountSubstrings
 * @Description TODO
 * @Date 2022/6/28 15:10
 * @Created by fy
 */
public class CountSubstrings {
    @Test
    public void test(){
        int res = countSubstrings("aaaa");
        System.out.println(res);
    }
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        res += len;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int l = 2; l <= len; l++){
            for(int i = 0; i <= len - l; i++){
                int j = i + l - 1;
                boolean b = s.charAt(i) == s.charAt(j);
                if(l == 2) dp[i][j] = b;
                else{
                    dp[i][j] = dp[i + 1][j - 1] && b;
                }
                res += dp[i][j] ? 1 : 0;
            }
        }
        return res;
    }
}
