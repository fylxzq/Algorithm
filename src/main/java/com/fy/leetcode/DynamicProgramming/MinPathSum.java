package com.fy.leetcode.DynamicProgramming;

/**
 * @Classname MinPathSum
 * @Description TODO
 * @Date 2022/1/19 18:07
 * @Created by fy
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0 ; i < row; ++i){
            for(int j = 0;j < col; ++j){
                if(i - 1 < 0 && j - 1< 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i - 1 < 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                else if(j - 1 < 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[row-1][col-1];
    }
}
