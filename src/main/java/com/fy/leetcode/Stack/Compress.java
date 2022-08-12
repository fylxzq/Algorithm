package com.fy.leetcode.Stack;

import org.junit.Test;

import java.util.Deque;

/**
 * @Classname Compress
 * @Description TODO
 * @Date 2022/5/9 22:06
 * @Created by fy
 */
public class Compress {
    @Test
    public void test(){
        char[] chars = {'a','a','b','b','c','c','c'};
        compress(chars);
    }
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int len = chars.length;
        int i = 0;
        int j = 1;
        while (j <= len){
            if(j == len || chars[j] != chars[i]){
                sb.append(chars[i]);
                if(j - i > 1){
                    sb.append(j - i);
                }
                i = j;
            }
            j++;
        }
        String s = sb.toString();
        for(int k = 0; i < s.length(); k++){
            chars[k] = s.charAt(k);
        }
        return s.length();
    }
}
