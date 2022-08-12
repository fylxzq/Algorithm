package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WordBreak
 * @Description TODO
 * @Date 2022/3/13 22:03
 * @Created by fy
 */
public class WordBreak {
    @Test
    public void test() {
        List<String> worddict = new ArrayList<>();
        worddict.add("leet");
        worddict.add("code");
        wordBreak("leetcode", worddict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(String word : wordDict){
                if(i >= word.length()){
                    if(word.equals(s.substring(i - word.length(),i))){
                        dp[i] = dp[i] || dp[i - word.length()];
                    }
                }
            }
        }
        return dp[len];
    }

}
