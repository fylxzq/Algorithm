package com.fy.leetcode.Strs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Classname ReverseWords3
 * @Description TODO
 * @Date 2022/3/29 13:23
 * @Created by fy
 */
public class ReverseWords3 {
    @Test
    public void test(){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j <= chars.length){
            if (j == chars.length || chars[j] == ' '){
                int k = j - 1;
                while (i < k){
                    swap(chars, i, k);
                    ++i;
                    --k;
                }
                i = j + 1;
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for(char e: chars){
            sb.append(e);
        }
        return sb.toString();
    }

    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
