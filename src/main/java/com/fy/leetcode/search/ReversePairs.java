package com.fy.leetcode.search;

import org.junit.Test;

/**
 * @Classname ReversePairs
 * @Description TODO
 * @Date 2022/3/10 8:43
 * @Created by fy
 */
public class ReversePairs {
    @Test
    public void test() {
    }

    public int reversePairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int right  = nums.length - 1;
        int left = 0;
        int mid = left + (right - left) / 2;
        int[] tmp = new int[nums.length];
        return reversePairs(nums,left,right,tmp);
    }

    public int reversePairs(int[] nums,int left,int right,int[] tmp){
        if(left == right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int lefrPairs = reversePairs(nums,left,mid,tmp);
        int rigitPairs = reversePairs(nums,mid + 1 ,right,tmp);

        int curPairs = 0;
        if(nums[mid] <= nums[mid + 1]){
            curPairs = 0;
        }
        else{
            curPairs = mergeAndCount(nums, left, mid, right, tmp);
        }
        return lefrPairs + rigitPairs + curPairs;

    }


    private int mergeAndCount(int[] nums,int left,int mid,int right,int [] tmp){
        for(int i = left; i  <= right; ++i){
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for(int k = left; k <= right - left; ++k){
            if(i == mid + 1){
                nums[k] = tmp[j];
                ++j;
            }
            else if(j == right + 1){
                nums[k] = tmp[i];
                ++i;
            }
            else if(tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                ++i;
            }
            else{
                nums[k] = tmp[j];
                count += (mid - left + 1);
                ++j;
            }
        }
        return  count;
    }

}
