package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Classname MergeSortedArray
 * @Description TODO
 * @Date 2021/12/22 16:55
 * @Created by fy
 */
public class MergeSortedArray {

    @Test
    public void test(){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a -b);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        System.out.println(queue.poll());

    }
    public void merge(int[] nums1,int m,int[] nums2,int n){

        while ((m-1) >=0 && (n-1) >=0 ){
            if(nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
            else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }
}
