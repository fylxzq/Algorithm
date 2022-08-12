package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

/**
 * @Classname IsMatch
 * @Description TODO
 * @Date 2022/5/9 20:26
 * @Created by fy
 */
public class IsMatch {
    @Test
    public void test(){
        System.out.println(isMatch("aa", "aa"));
    }

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new  boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int i = 1; i <= plen; i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 1];
            }
            else {
                dp[0][i] = false;
            }
        }
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                char char1 = s.charAt(i - 1);
                char char2 = p.charAt(j - 1);
                if(char2 == '?' || char1 == char2){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(char2 == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[slen][plen];
    }
}
