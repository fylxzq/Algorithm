package com.fy.leetcode.Array;

import org.junit.Test;

/**
 * @Classname FindDuplicate
 * @Description TODO
 * @Date 2022/3/19 22:26
 * @Created by fy
 */
public class FindDuplicate {

    @Test
    public void test(){
        int[] nums = {1,3,4,2,2};
        findDuplicate(nums);
    }
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int l = 1, r = len - 1;
        int res = -1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            int cnt = 0;
            for(int i = 0; i < len; ++i){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                l = mid + 1;
            }
            else{
                r = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
