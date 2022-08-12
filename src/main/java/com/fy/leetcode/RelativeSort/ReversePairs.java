package com.fy.leetcode.RelativeSort;

import org.junit.Test;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname ReversePairs
 * @Description TODO
 * @Date 2022/4/21 19:14
 * @Created by fy
 */
public class ReversePairs {

    @Test
    public  void test(){
        int[] nums = {7,5,6,4};
        reversePairs(nums, 0, 3);
    }
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums,int low, int high){
        if(low >= high){
            return 0;
        }
        int mid = (high - low) / 2 + low;
        int leftPairs = reversePairs(nums,low,mid);
        int rightPairs = reversePairs(nums, mid + 1, high);
        int curPairs = 0;
        if(nums[mid] >= nums[mid + 1]){
            curPairs = merge(nums,low,mid,high);
        }
        return leftPairs + rightPairs + curPairs;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int[] tmpArr = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int count = 0;
        int res = 0;
        while (i <= mid || j <= high){
            long leftVal = i <= mid ? nums[i] : Long.MAX_VALUE;
            long rigtVal = j <= high ? nums[j] : Long.MAX_VALUE;
            if(leftVal > rigtVal){
                res += mid - i + 1;
                tmpArr[count++] = (int) rigtVal;
                j++;
            }
            else{
                tmpArr[count++] = (int) leftVal;
                i++;
            }
        }
        if (high - low + 1 >= 0) System.arraycopy(tmpArr, 0, nums, low, high - low + 1);
        return res;
    }
}
