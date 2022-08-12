package com.fy.leetcode.Array;

/**
 * @Classname MinimumOperations
 * @Description TODO
 * @Date 2022/7/31 10:32
 * @Created by fy
 */
public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        int len = nums.length;
        boolean[] vis = new boolean[len];
        int preMin = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                vis[i] = true;
                count++;
            }
            else{
                preMin = Math.min(preMin, nums[i]);
            }
        }
        int res = 0;
        while (count < len){
            int curMin = preMin;
            preMin = Integer.MAX_VALUE;
            for(int i = 0; i < len; i++){
                if(!vis[i]){
                    nums[i] -= curMin;
                    if(nums[i] == 0){
                        vis[i] = true;
                        count++;
                    }
                    else{
                        preMin = Math.min(nums[i],preMin);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
