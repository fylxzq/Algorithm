package com.fy.leetcode.search;

/**
 * @Classname BinarySearch
 * @Description TODO
 * @Date 2021/12/28 11:25
 * @Created by fy
 */
public class BinarySearch {

    public int search(int[] nums, int target){
        int len = nums.length;
        return binarysearch(nums,0,len-1,target);
    }

    public int binarysearch(int[] nums,int low,int high,int target){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else{
            return nums[mid] > target ? binarysearch(nums, mid  + 1, high, target):binarysearch(nums, low, mid-1, target);
        }
    }
}
