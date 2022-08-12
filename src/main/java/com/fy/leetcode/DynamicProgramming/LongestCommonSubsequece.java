package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LongestCommonSubsequece
 * @Description TODO
 * @Date 2022/1/14 12:59
 * @Created by fy
 */
public class LongestCommonSubsequece {

    @Test
    public void test(){
        longestCommonSubsequence("abcbdab", "bdcaba");
    }
    public void longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int[][] directions = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                    directions[i][j] = 2;
                }
                else{
                    if(dp[i - 1][j] >= dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j];
                        directions[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i][j - 1];
                        directions[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, text1, directions, len1, len2);
        System.out.println(sb.toString());
    }

    public void dfs(StringBuilder sb,String text1,int[][] directions,int i,int j){
        if(i == 0 || j == 0){
            return;
        }
        if(directions[i][j] == 2){
            sb.append(text1.charAt(i - 1));
            dfs(sb, text1, directions, i - 1, j - 1);
        }
        else if(directions[i][j] == 1){
            dfs(sb, text1, directions, i - 1, j);
        }
        else{
            dfs(sb, text1, directions, i, j - 1);
        }
    }
}
