package com.fy.leetcode.RelativeSort;

import org.junit.Test;

/**
 * @Classname SortColors
 * @Description TODO
 * @Date 2022/3/12 9:21
 * @Created by fy
 */
public class SortColors {
    @Test
    public void test() {

    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int i = 0;
        while (i <= right){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
            if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
            ++i;
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}
