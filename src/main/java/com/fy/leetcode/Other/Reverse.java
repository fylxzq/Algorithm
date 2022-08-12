package com.fy.leetcode.Other;

import org.junit.Test;

/**
 * @Classname Reverse
 * @Description TODO
 * @Date 2021/7/28 14:29
 * @Created by fy
 */
public class Reverse {

    public int reverse(int x){
        int rev = 0;
        while (x !=0 ){
            if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE /10){
                return 0;//rev*10 + digit <= INT_MAX -> rev * 10 + digit <= 向下取整(INT_MAX / 10) *10 + INT_MAX % 10
            }
            else{
                int digit = x % 10;//-12 除以10的余数等于-2
                x /= 10;
                rev = rev * 10 + digit;
            }
        }
        return rev;
    }
}
