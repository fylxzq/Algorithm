package com.fy.leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * @Classname MinPathCost
 * @Description TODO
 * @Date 2022/6/12 10:53
 * @Created by fy
 */
public class MinPathCost {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(grid[0], 0, dp[0], 0, n);
        for(int i = 1; i < m; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i- 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        int res = dp[m - 1][0];
        for(int i = 1; i < n; i++){
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
