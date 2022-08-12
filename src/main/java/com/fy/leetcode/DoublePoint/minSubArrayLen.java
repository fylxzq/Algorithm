package com.fy.leetcode.DoublePoint;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname minSubArrayLen
 * @Description TODO
 * @Date 2022/4/16 16:36
 * @Created by fy
 */
public class minSubArrayLen {

    @Test
    public void test(){
        minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] presum = new int[len + 1];
        for(int i = 0; i < len; i++){
            presum[i + 1] = presum[i] + nums[i];
        }
        int res = nums.length;
        for(int i = 1; i < len; i++){
            int newTarget = target + presum[i - 1];
            int index = Arrays.binarySearch(presum, newTarget);//求从头第i - 1个为首的大于targer的连续长度
            if(index < 0){
                index = -index - 1;
            }
            if(index <= len){
                res = Math.min(res, index - i + 1);
            }
        }
        return res;
    }
}
