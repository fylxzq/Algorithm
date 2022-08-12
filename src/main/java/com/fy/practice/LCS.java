package com.fy.practice;

import org.junit.Test;

/**
 * @Classname LCS
 * @Description TODO
 * @Date 2021/1/13 20:02
 * @Created by fy
 */
public class LCS {
    @Test
    public void test(){
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        int rst = lcs(str1,str2);
        System.out.println(rst);
    }

    public int lcs(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+2];//dp的长度比字符串的长度大1，因为两边需要为1
        for(int i=0;i<len1;++i){
            for(int j=0;j<len2;++j){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[len1][len2];

    }
}
