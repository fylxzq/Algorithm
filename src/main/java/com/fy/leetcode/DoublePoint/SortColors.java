package com.fy.leetcode.DoublePoint;

/**
 * @Classname sortColors
 * @Description TODO
 * @Date 2022/4/26 16:47
 * @Created by fy
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        int k = i;
        while (k < j){
            if(nums[k] == 2){
                swap(nums, k, j);
                --j;
            }
            else if(nums[k] == 0){
                swap(nums, i, k);
                ++i;
            }
            ++k;
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
