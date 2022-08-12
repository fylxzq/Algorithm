package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname TriangleNumber
 * @Description TODO
 * @Date 2022/3/31 8:47
 * @Created by fy
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len - 1; j++){
                int k = j + 1;
                while (k < len && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                res += k - j - 1;
            }
        }
        return res;
    }
}
