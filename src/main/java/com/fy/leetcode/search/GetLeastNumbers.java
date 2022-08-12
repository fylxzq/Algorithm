package com.fy.leetcode.search;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname GetLeastNumbers
 * @Description TODO
 * @Date 2022/3/8 10:21
 * @Created by fy
 */
public class GetLeastNumbers {
    @Test
    public void test() {
        int[] nums = {4,5,1,6,2,7,3,8};
        quicksort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        int[] rst = new int[k];
        getK(arr, 0, high, k);
        for(int i = 0; i < k; ++i){
            rst[i] = arr[i];
        }
        return rst;
    }

    public void getK(int[] arr,int low,int high,int k){
        int mid = partition(arr, low, high);
        if(mid == k - 1){
            return;
        }
        else if(mid > k - 1){
            getK(arr, low, mid - 1, k);
        }
        else{
            getK(arr, mid + 1, high, k);
        }
    }

    public void quicksort(int[] nums,int low,int high){
       if(low >=high)return;
            int mid = partition(nums,low,high);
            quicksort(nums, low, mid - 1);
            quicksort(nums, mid + 1, high);


    }

    public int partition(int[] nums,int low,int high){
        int tmp = nums[low];
        while (low < high){
            while (low < high && nums[high] >= tmp){
                --high;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < tmp){
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }
}
