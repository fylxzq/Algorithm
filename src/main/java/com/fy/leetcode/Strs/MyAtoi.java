package com.fy.leetcode.Strs;

import org.junit.Test;

import java.nio.channels.SelectableChannel;

/**
 * @Classname MyAtoi
 * @Description TODO
 * @Date 2021/8/1 15:06
 * @Created by fy
 */
public class MyAtoi {

    @Test
    public void test(){
       int a = 1;
        System.out.println(a > Long.MIN_VALUE);
    }
    public int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        if(len < 1){
            return 0;
        }
        int index = 0;
        char firstchar = s.charAt(0);
        int flag = 1;
        if( !Character.isDigit(firstchar) && firstchar == '+' && firstchar == '-') return 0;
        if(firstchar == '-' || firstchar == '+') index = 1;
        if(firstchar == '-'){
            flag = -1;
        }
        int rst = 0;
        while (index < len){
            char tmpchr = s.charAt(index);
            if(Character.isDigit(tmpchr)){
                int tmpvalue = tmpchr - '0';
                if(rst < Integer.MIN_VALUE / 10 || rst == Integer.MIN_VALUE / 10 && tmpvalue > 8){
                    return Integer.MIN_VALUE;
                }
                if(rst > Integer.MAX_VALUE / 10 || rst == Integer.MAX_VALUE / 10 && tmpvalue > 7){
                    return Integer.MAX_VALUE;
                }
                rst = rst * 10 + tmpvalue * flag;
            }
            else{
                break;
            }
        }
        return rst;
    }

}