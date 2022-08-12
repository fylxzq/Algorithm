package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname ADDString
 * @Description TODO
 * @Date 2021/12/23 22:25
 * @Created by fy
 */
public class ADDString {


    public String addString(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1;
        int j = len2 - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0){
            int tmpvalue1 = i >=0 ? num1.charAt(i) - '0' : 0;
            int tmpvalue2 = j >=0 ? num1.charAt(j) - '0' : 0;
            int value = tmpvalue1 + tmpvalue2 + carry;
            builder.append(value % 10);
            carry = value / 10;
            j--;
            i--;
        }
        builder.reverse();
        return builder.toString();
    }
}
