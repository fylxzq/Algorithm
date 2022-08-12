package com.fy.leetcode.BackTrack;

import java.util.Arrays;

/**
 * @Classname Makesquare
 * @Description TODO
 * @Date 2022/6/13 15:26
 * @Created by fy
 */
public class Makesquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num :matchsticks){
            sum += num;
        }
        if(sum % 4 != 0 || matchsticks.length < 4){
            return false;
        }
        Arrays.sort(matchsticks);
        int target = sum / 4;
        return dfs(matchsticks, matchsticks.length - 1,new int[4],target);
    }

    public boolean dfs(int[] matchsticks, int index,int[] bucket,int target){
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
        for(int i = 0; i < 4; i++){
            if(i > 0 && bucket[i - 1] == bucket[i]) continue;
            if(i > 0 && index == matchsticks.length - 1) continue; //剪枝，将第一个数放入第一个桶
            if(bucket[i] + matchsticks[index] > target) continue;//剪枝：当前桶放入nums[index]溢出了
            bucket[i] += matchsticks[index];
            boolean falg = dfs(matchsticks, index - 1,bucket, target);
            if(falg){
                return true;
            }
            bucket[i] -= matchsticks[index];
        }
        return false;
    }
}
