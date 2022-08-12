package com.fy.leetcode.Other;

import org.junit.Test;

/**
 * @Classname HammingWeight
 * @Description TODO
 * @Date 2022/3/25 13:59
 * @Created by fy
 */
public class HammingWeight {
    @Test
    public void test(){
        System.out.println(1 << 1);
    }

    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }
        else if(n > 0){
            return countOne(n);
        }
        else{
            return 32 - countOne(n ^ -1);
        }
    }

    private int countOne(int n) {
        int count = 0;
        while (n != 0){
            if (n % 2 == 1){
                ++count;
            }
            n /= 2;
        }
        return count;
    }
}
