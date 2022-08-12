package com.fy.leetcode.RelativeSort;

import org.junit.Test;

import java.security.PublicKey;
import java.util.*;

/**
 * @Classname Base_Sort
 * @Description TODO
 * @Date 2021/8/10 12:27
 * @Created by fy
 */
public class Base_Sort {

    public void mergeSort(int[] nums,int l,int r){
        if(l >= r){
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums,l,mid,r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        for(int k = 0; k < r - l + 1; k++){
            if(i <= mid && j <= r){
                if(nums[i] <= nums[j]){
                    tmp[k] = nums[i];
                    i++;
                }
                else{
                    tmp[k] = nums[j];
                    j++;
                }
            }
            else if(i <= mid){
                tmp[k] = nums[i];
                i++;
            }
            else{
                tmp[k] = nums[j];
                j++;
            }
        }
        for(int k = 0; k < r - l + 1; k++){
            nums[k + l] = tmp[k];
        }
    }

    public void quicksort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int mid = partition(arr, low, high);
        quicksort(arr, low, mid - 1);
        quicksort(arr, mid + 1, high);
    }

    public int partition(int[] arr,int low,int high){
        int tmp = arr[low];
        while (low < high){
            while (low < high && arr[high] > tmp){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public  void heapsort(int[] arr){
        int len = arr.length;
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            sink(arr, i, len);
        }
        for(int i = 0;i < len; ++i){
            int tmp = arr[len - i - 1];
            arr[len - i - 1] = arr[0];
            arr[0] = tmp;
            sink(arr,0,len - i - 1);
        }
    }


    @Test
    public void test(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int len = nums.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            sink(nums,i,len);
        }
        int count = 0;
        while(count < len){
            swap(nums,0,len - count - 1);
            sink(nums,0,len - count - 1);
            ++count;
        }
        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            sink(nums,i,len);
        }
        for(int i = 0; i < k; i++){
            swap(nums,i,len - i - 1);
            sink(nums,i,len - i - 1);
        }
        return nums[len - k];
    }

    public void sink(int[] nums,int k,int len){
        int tmp = k;
        k = 2 * k + 1;
        while (k < len){
            if(k + 1 < len && nums[k + 1] > nums[k]){
                k = k + 1;
            }
            if(nums[k] > nums[tmp]){
                swap(nums,tmp,k);
                tmp = k;
                k = 2 * k + 1;
            }
            else {
                break;
            }
        }
    }


    public void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
