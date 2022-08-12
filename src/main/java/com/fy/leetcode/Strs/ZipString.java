package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname ZipString
 * @Description TODO
 * @Date 2022/7/21 9:54
 * @Created by fy
 */
public class ZipString {

    @Test
    public void test(){
        String s = "aabcccccaaa";
        System.out.println(zipString(s));
    }
    public String zipString(String iniString){
        StringBuilder sb = new StringBuilder();
        int len = iniString.length();
        int i = 0;
        int j = 0;
        while (j <= len){
            if(j == len || iniString.charAt(j) != iniString.charAt(i)){
                sb.append(iniString.charAt(i));
                sb.append(j - i);
                i = j;
            }
            j++;
        }
        return sb.length() < len ? sb.toString() : iniString;
    }
}
