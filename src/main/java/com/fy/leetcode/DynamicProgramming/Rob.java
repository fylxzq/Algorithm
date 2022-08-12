package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

/**
 * @Classname Rob
 * @Description TODO
 * @Date 2022/2/27 16:32
 * @Created by fy
 */
public class Rob {
    @Test
    public void test() {
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int rst = 0;
        int pre_stole = 0;
        int pre_no_stole = 0;
        for (int num : nums) {
            int cur_stole = pre_no_stole + num;
            int cur_no_stole = Math.max(pre_stole, pre_no_stole);
            pre_no_stole = cur_no_stole;
            pre_stole = cur_stole;
        }
        return Math.max(pre_stole, pre_no_stole);
    }
}
