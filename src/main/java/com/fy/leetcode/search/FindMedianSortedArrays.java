package com.fy.leetcode.search;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

/**
 * @Classname FindMedianSortedArrays
 * @Description TODO
 * @Date 2021/7/24 11:11
 * @Created by fy
 */
public class FindMedianSortedArrays {

    @Test
    public void test(){
        int[] nums1 = {1,4};
        int[] nums2 = {2,3,5,6};
        findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (double) (getKthnum(nums1,0,len1 - 1,nums2,0,len2 - 1,left) + getKthnum(nums1,0,len1 - 1,nums2,0,len2 - 1,right)) / 2;
    }

    public int getKthnum(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 == 0){
            return nums2[start2 + k - 1];
        }
        else if(len2 == 0){
            return nums1[start1 + k - 1];
        }
        else if(k == 1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int newstart1 = start1 + Math.min(len1,k / 2);
        int newstart2 = start2 + Math.min(len2,k / 2);
        if(nums1[start1] > nums2[start2]){
            return getKthnum(nums1,start1,end1,nums2,newstart2,end2,k - (newstart2 - start2));
        }
        else{
            return getKthnum(nums1,newstart1,end1,nums2,start2,end2,k - (newstart1 - start1));
        }
    }
}
