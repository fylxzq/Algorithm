package com.fy.leetcode;

/**
 * @Classname SpinArraySearch
 * @Description TODO
 * @Date 2021/12/26 18:11
 * @Created by fy
 */
public class SpinArraySearch {

    public int search(int[] nums, int target){
        int len = nums.length;
        return binarysearch(nums, 0,len-1, target);
    }

    public int binarysearch(int[] nums,int low,int high,int target){
        int mid = (low + high) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else if(low == high && nums[mid] != target){
            return -1;
        }
        else if(nums[mid] >= nums[low]){
            if(target >= nums[low] && nums[mid] > target){
                return binarysearch(nums, low, mid-1, target);
            }else {
                return binarysearch(nums, mid+1, high, target);
            }
        }
        else{
            if (target > nums[mid] && nums[high] >= target){
                return binarysearch(nums, mid+1, high, target);
            }
            else{
                return binarysearch(nums, low, mid-1, target);
            }
        }
    }

}
