package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;

import java.util.List;

/**
 * @Classname MinimumTotal
 * @Description TODO
 * @Date 2022/5/9 21:40
 * @Created by fy
 */
public class MinimumTotal {
    @Test
    public void test(){

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size  = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < size; i++){
            int[] newdp = new int[size];
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size(); j++){
                if(j == 0){
                    newdp[j] = dp[j] + list.get(j);
                }
                else if(j == list.size() -1){
                    newdp[j] = dp[j - 1] + list.get(j);
                }
                else{
                    newdp[j] = Math.min(dp[j - 1],dp[j]) + list.get(j);
                }
            }
            dp = newdp;
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
