package com.fy.leetcode.BackTrack;

import java.util.Arrays;

/**
 * @Classname CanPartitionKSubsets
 * @Description TODO
 * @Date 2022/6/13 14:26
 * @Created by fy
 */
public class CanPartitionKSubsets {
    private int res = Integer.MAX_VALUE;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num :nums){
            sum += num;
        }
        if(sum % k != 0 || nums.length < k){
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        return dfs(nums, nums.length - 1, k,new int[k],target);
    }

    public boolean dfs(int[] nums,int index,int k,int[] bucket, int target){
        if(index < 0){
            return true;
        }
        int zeroCount = 0;
        for(int num : bucket){
            zeroCount += num == 0 ? 1 : 0;
        }
        if(zeroCount > index + 1){
            return false;
        }
        for(int i = 0; i < k; i++){
            if(i > 0 && index == nums.length - 1) continue; //剪枝，将第一个数放入第一个桶
            if(bucket[i] + nums[index] > target) continue;//剪枝：当前桶放入nums[index]溢出了
            if(i > 0 && bucket[i - 1] == bucket[i]) continue;
            bucket[i] += nums[index];
            boolean falg = dfs(nums, index - 1, k,bucket, target);
            if(falg){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;

    }
}
