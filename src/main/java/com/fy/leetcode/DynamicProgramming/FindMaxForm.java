package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname FindMaxForm
 * @Description TODO
 * @Date 2022/6/15 19:31
 * @Created by fy
 */
public class FindMaxForm {
    @Test
    public void test(){
        String[] strs = {"10","0001","111001","1","0"};
        findMaxForm(strs, 3, 3);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str :strs){
            int zeroNum = 0;
            int oneNum = 0;
            for(char e : str.toCharArray()){
                zeroNum += e == '0' ? 1 : 0;
                oneNum +=  e == '1' ? 1 : 0;
            }
            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i - zeroNum][j - oneNum] +1,dp[i][j]);
                }
            }
            for(int i = 0; i <= m; i++){
                System.out.println(Arrays.toString(dp[i]));
            }
            System.out.println("===========");
        }
        return dp[m][n];
    }
}
