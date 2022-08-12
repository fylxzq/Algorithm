package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Classname CountPaths
 * @Description TODO
 * @Date 2022/7/3 11:26
 * @Created by fy
 */
public class CountPaths {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = m * n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = 1;
            }
        }
        for(int l = 2; l <= m * n; l++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(dp[i][j] != 0){
                        //ÉÏÏÂ×óÓÒ
                        boolean flag = false;
                        if(i - 1 >= 0 && grid[i][j] > grid[i - 1][j] && dp[i - 1][j] == l - 1){
                            dp[i][j]+= dp[i - 1][j];
                            flag = true;
                        }
                        if(i + 1 < m && grid[i][j] > grid[i + 1][j] && dp[i + 1][j] == l - 1){
                            dp[i][j] += dp[i + 1][j];
                            flag = true;
                        }
                        if(j - 1 >= 0 && grid[i][j] > grid[i][j -1] && dp[i][j - 1] == l - 1){
                            dp[i][j] += dp[i][j - 1];
                            flag = true;
                        }
                        if(j + 1 < n && grid[i][j] > grid[i][j + 1] && dp[i][j + 1] == l - 1){
                            dp[i][j] += dp[i][j + 1];
                            flag = true;
                        }
                        dp[i][j] = flag ? dp[i][j] : 0;
                    }
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
