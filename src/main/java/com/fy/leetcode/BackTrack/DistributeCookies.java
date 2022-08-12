package com.fy.leetcode.BackTrack;

import java.util.Arrays;

/**
 * @Classname DistributeCookies
 * @Description TODO
 * @Date 2022/6/13 15:12
 * @Created by fy
 */
public class DistributeCookies {
    private int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        dfs(cookies, cookies.length - 1, k, new int[k]);
        return res;
    }

    public void dfs(int[] cookies,int index,int k, int[] bucket){
        if(index < 0){
            int tmpRes = Integer.MIN_VALUE;
            for(int num : bucket){
                tmpRes = Math.max(num, tmpRes);
            }
            res = Math.min(res, tmpRes);
        }
        int zeroCount = 0;
        for(int num : bucket){
            zeroCount += num == 0 ? 1 : 0;
        }
        if(zeroCount > index + 1){
            return;
        }
        for(int i = 0; i < k; i++){
            if(i > 0 && bucket[i] == bucket[i - 1]) continue;
            if(i > 0 && index == cookies.length - 1){
                continue;
            }
            if(bucket[i] + cookies[index] > res){
                continue;
            }
            dfs(cookies, index - 1, k , bucket);
            bucket[i] -= cookies[index];
        }
    }
}
