package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

/**
 * @Classname LongestValidParentheses
 * @Description TODO
 * @Date 2022/4/9 22:04
 * @Created by fy
 */
public class LongestValidParentheses {

    @Test
    public void test(){
        String s = "(()())()()(()())(";
        longestValidParentheses(s);
    }
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }
            else{
                if(i > 0 && s.charAt(i - 1) == '('){
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }
                if(i > 0 && s.charAt(i - 1) == ')'){
                    if(i - dp[i - 1] - 1 < 0 || s.charAt(i - dp[i] - 1) == ')'){
                        dp[i] = 0;
                    }
                    else{
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] -2] : 0);
                    }
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;

    }
}
