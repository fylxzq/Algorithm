package com.fy.leetcode.DynamicProgramming;

import org.omg.CORBA.INTERNAL;

/**
 * @Classname SubMaxMatrix
 * @Description TODO
 * @Date 2021/8/27 21:47
 * @Created by fy
 */
public class SubMaxMatrix {

    public int[] getMaxMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rst = new int[4];
        int[] dp = new int[col];
        int best_row = 0;
        int best_col = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0;i < row; ++i){
            for(int k = 0;k < col; ++k){
                dp[k] = 0;
            }
            for(int j = i;j < row; ++j){
                int sum = 0;
                for(int k = 0;k < col; ++k){
                    dp[k] += matrix[j][k];
                    if(sum > 0){
                        sum += dp[k];
                    }
                    else{
                        sum = dp[k];
                        best_row = i;
                        best_col = k;
                    }
                    if(sum > maxsum){
                        maxsum = sum;
                        rst[0] = best_row;
                        rst[1] = best_col;
                        rst[2] = j;
                        rst[3] = k;
                    }
                }
            }
        }
        return rst;
    }
}
