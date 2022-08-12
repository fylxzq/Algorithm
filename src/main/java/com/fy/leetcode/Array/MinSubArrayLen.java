package com.fy.leetcode.Array;

import org.junit.Test;

/**
 * @Classname MinSubArrayLen
 * @Description TODO
 * @Date 2022/2/28 10:45
 * @Created by fy
 */
public class MinSubArrayLen {
    @Test
    public void test() {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int i = 0;
        int j = 0;
        int rst = Integer.MAX_VALUE;
        while (j < len){
            sum += nums[j];
            while (sum >= target && i <= j ){
                rst = Math.min(rst, j - i + 1);
                sum -= nums[i--];
            }
            ++j;
        }
        return rst;
    }
}
