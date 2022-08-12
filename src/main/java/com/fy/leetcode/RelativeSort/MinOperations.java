package com.fy.leetcode.RelativeSort;

import java.util.Arrays;

/**
 * @Classname MinOperations
 * @Description TODO
 * @Date 2022/7/17 20:02
 * @Created by fy
 */
public class MinOperations {
    public int minOperations(int[] nums, int[] numsDivide) {
        int res = numsDivide[0];
        for(int divide : numsDivide){
            res = gcd(res,divide);
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(res % nums[i] == 0){
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
