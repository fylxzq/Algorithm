package com.fy.leetcode.Strs;

import org.junit.Test;

/**
 * @Classname RemoveDigit
 * @Description TODO
 * @Date 2022/5/1 10:31
 * @Created by fy
 */
public class RemoveDigit {

    @Test
    public void test(){
        removeDigit("872784", '8');
    }
    public String removeDigit(String number, char digit) {
        int len = number.length();
        boolean flag = false;
        int p = 0;
        for(int i = 0; i < len - 1; i++){
            if(number.charAt(i) == digit && number.charAt(i) < number.charAt(i + 1)){
                flag = true;
                p = i;
            }
        }
        if(!flag){
            for(int i = len - 1; i >= 0; i--){
                if (number.charAt(i) == digit){
                    p = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len ;i++){
            if(i != p){
                sb.append(number.charAt(i));
            }
        }
        return sb.toString();
    }
}
