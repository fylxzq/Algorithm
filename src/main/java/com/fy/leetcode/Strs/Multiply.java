package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname Multiply
 * @Description TODO
 * @Date 2022/1/21 8:58
 * @Created by fy
 */
public  class Multiply {

    @Test
    public void test(){
        String num1 = "123";
        String num2 = "456";
        multiply(num1, num2);
    }
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0){
            return "";
        }
        if(len1 == 1 && num1.charAt(0) == '0'){
            return "0";
        }
        if(len2 == 1 && num2.charAt(0) == '0'){
            return "0";
        }
        String rst = "";
        long count = 0;
        for(int i = len2 - 1; i >= 0; --i){
            int fac2 = num2.charAt(i) - '0';
            StringBuilder oneStepvalue = new StringBuilder();
            int carry = 0;
            for(int j = len1 - 1; j >= 0; --j){
                int fac1 = num1.charAt(j) - '0';
                int tmpvalue = fac1 * fac2 + carry;
                oneStepvalue.append(tmpvalue % 10);
                carry = tmpvalue / 10;
            }
            if(carry > 0){
                oneStepvalue.append(carry);
            }
            oneStepvalue.reverse();
            for(int k = 0; k < count;++k){
                oneStepvalue.append("0");
            }
            count ++;
            rst = addString(rst, oneStepvalue.toString());
        }
        return rst;
    }

    public String addString(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int i = len1 - 1 ;
        int j = len2 - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0){
            int value1 = i >= 0 ? str1.charAt(i) - '0' : 0;
            int value2 = j >= 0 ? str2.charAt(j) - '0' : 0;
            int tmpvalue = value1 + value2  + carry;
            stringBuilder.append(tmpvalue % 10);
            carry = tmpvalue / 10;
            --i;
            --j;
        }
        if(carry > 0){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}