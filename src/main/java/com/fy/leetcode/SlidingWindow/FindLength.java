package com.fy.leetcode.SlidingWindow;

import org.junit.Test;

/**
 * @Classname FindLength
 * @Description TODO
 * @Date 2022/1/19 9:28
 * @Created by fy
 */
public class FindLength {
    @Test
    public void test(){
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4};
        findLength(nums1, nums2);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            findLength(nums2,nums1);
        }
        int res = 0;
        for(int i = 1; i <= len1; i++){
            res = Math.max(res,getSameMaxLength(nums1,nums2,0,len2 - i,i));
        }
        for(int j = len2 - len1 - 1; j >= 0; j--){
            res = Math.max(res,getSameMaxLength(nums1,nums2,0,j,len1));
        }
        for(int k = 1; k < len1; k++){
            res = Math.max(res,getSameMaxLength(nums1,nums2,k,0,len1 - k));
        }
        return res;
    }

    public int getSameMaxLength(int[] nums1,int[] nums2,int begin1,int begin2,int len){
        int count = 0;
        int res = 0;
        for(int k = 0; k < len; k++){
            if(nums1[begin1 + k] == nums2[begin2 + k]){
                count++;
            }
            else{
                count = 0;
            }
            res = Math.max(res,count);
        }
        return res;
    }

}
