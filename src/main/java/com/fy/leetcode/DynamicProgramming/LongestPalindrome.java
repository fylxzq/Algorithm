package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.Map;

/**
 * @Classname LongestPalindrome
 * @Description TODO
 * @Date 2021/7/26 19:33
 * @Created by fy
 */
public class LongestPalindrome {


    @Test
    public void test(){
        String s = "ac";
        String a = longestPalindrome(s);
    }
    public String longestPalindrome(String s){
        int len = s.length();
        int start = 0 ,end = 0;
        for(int i = 0; i < len ; ++i){
            int len1 = expandExploreCenter(s, i,i);
            int len2 = expandExploreCenter(s,i, i+1);
            int onelen = Math.max(len1, len2);
            if(onelen > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandExploreCenter(String s,int left,int right){
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        };
        return right - left -1;
    }


}
