package com.fy.leetcode.Array;

import java.util.Arrays;

/**
 * @Classname GetMaxMatrix
 * @Description TODO
 * @Date 2022/5/19 19:11
 * @Created by fy
 */
public class GetMaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] preSum = new int[n];
        int maxSum = matrix[0][0];
        int startX = 0;
        int startY = 0;
        int[] res = new int[4];
        for(int i = 0; i < m; i++){
            Arrays.fill(preSum, 0);
            for(int j = i; j < m; j++){
                int sum = 0;//sum代表以索引k为结尾的最大子数组和
                for(int k = 0; k < n; k++){
                    preSum[k] = preSum[k] + matrix[j][k];
                    if(sum > 0){
                        sum += preSum[k];
                    }
                    else{
                        sum = preSum[k];
                        startX = i;
                        startY = k;
                    }
                    if(sum > maxSum){
                        maxSum = sum;
                        res[0] = startX;
                        res[1] = startY;
                        res[2] = j;
                        res[3] = k;
                    }
                }
            }
        }
        return res;
    }
}
