package com.fy.leetcode.Hash;

/**
 * @Classname FirstMissingPositive
 * @Description TODO
 * @Date 2022/1/18 11:02
 * @Created by fy
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len; ++i){
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] - 1);
            }
        }
        for(int i = 0;i < len;++i){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
