package com.fy.leetcode.Array;

import java.util.Arrays;

/**
 * @Classname MinimumRounds
 * @Description TODO
 * @Date 2022/4/17 10:53
 * @Created by fy
 */
public class MinimumRounds {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int len = tasks.length;
        if(len <= 1){
            return -1;
        }
       return dfs(tasks, 0);
    }

    private int dfs(int[] tasks,int i){
        if(i == tasks.length){
            return 0;
        }
        int j = i + 2;
        if(j < tasks.length && tasks[i] == tasks[j]){
            int nextRounds = dfs(tasks, j + 1);
            if(nextRounds != -1){
                return nextRounds + 1;
            }
        }
        j = i + 1;
        if(j < tasks.length && tasks[i] == tasks[j]){
            int nextRounds = dfs(tasks, j + 1);
            if(nextRounds != -1){
                return nextRounds + 1;
            }
        }
        return -1;
    }
}
