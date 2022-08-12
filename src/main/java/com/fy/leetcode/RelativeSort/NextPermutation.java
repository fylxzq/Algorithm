package com.fy.leetcode.RelativeSort;

/**
 * @Classname nextPermutation
 * @Description TODO
 * @Date 2022/1/13 18:33
 * @Created by fy
 */
public class NextPermutation {
    public void nextPermutation(int[] nums){
        int len = nums.length;
        if(len == 1){
            return;
        }
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            --i;
        }
        for(int j = len - 1;j > i;--j){
            if(nums[j] > nums[i]){
                swap(i, j, nums);
                j = len - 1;
                ++i;
                reverse(i, j, nums);
                break;
            }
        }

    }

    public void swap(int i,int j,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int i,int j,int[] nums){
        while (i < j){
            swap(i, j, nums);
            i++;j--;
        }
    }
}
