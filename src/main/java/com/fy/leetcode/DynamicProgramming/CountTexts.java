package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

/**
 * @Classname CountTexts
 * @Description TODO
 * @Date 2022/5/9 14:49
 * @Created by fy
 */
public class CountTexts {
    @Test
    public void test(){
        System.out.println(countTexts("223"));
    }
    public int countTexts(String pressedKeys) {
        int mod = (int) (1e9 + 7);
        char[] chars = pressedKeys.toCharArray();
        int len = chars.length;
        long[] dp = new long[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            dp[i] = dp[i - 1];
            if(chars[i] == chars[i - 1]){
                dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
                if(i - 2 >= 0 && chars[i] == chars[i - 2]){
                    dp[i] += i - 3 >= 0 ? dp[i - 3] : 1;
                    if((chars[i] == '7' || chars[i] == '9') && i >= 3 && chars[i] == chars[i - 3]){
                        dp[i] += i - 4 >= 0 ? dp[i - 4] : 1;
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) dp[len - 1];
    }
}
