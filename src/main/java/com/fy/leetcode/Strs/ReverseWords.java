package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname reverseWords
 * @Description TODO
 * @Date 2022/1/11 12:30
 * @Created by fy
 */
public class ReverseWords {

    @Test
    public void test(){
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = len - 1;
        int j = len - 1;
        while (i >= 0 && s.charAt(i) == ' ' ){
            --i;
            --j;
        }
        while (j >= 0  &&  s.charAt(j) != ' ' ){
            if(j == 0 && s.charAt(j) != ' '){
                sb.append(s.substring(j,i+1));
                sb.append(" ");
                break;
            }
            --j;
            if(j >= 0 && s.charAt(j) == ' '){
                sb.append(s.substring(j+1,i+1));
                sb.append(" ");
                while (j >= 0 && s.charAt(j) == ' '){
                    --j;
                }
                i = j;
            }
        }
        return sb.toString().trim();
    }
}
