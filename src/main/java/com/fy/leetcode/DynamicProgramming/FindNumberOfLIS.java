package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Classname FindNumberOfLIS
 * @Description TODO
 * @Date 2022/5/9 22:40
 * @Created by fy
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];//������iΪ���һ��������ĵ���������
        int[] cnt = new int[len];//������iΪ���һ��������ĵ��������еĸ���
        int maxLen = 0;
        int res = 0;
        for(int i = 1; i < len; i++){
            for (int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j + 1];
                        cnt[i] = cnt[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                res = cnt[i];
            }
            else if(dp[i] == maxLen){
                res += cnt[i];
            }
        }
        return res;
    }
}
