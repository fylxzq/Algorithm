package com.fy.leetcode.Array;

import org.junit.Test;

/**
 * @Classname GenerateMatrix
 * @Description TODO
 * @Date 2022/3/9 9:15
 * @Created by fy
 */
public class GenerateMatrix {
    @Test
    public void test() {
    }
    public int[][] generateMatrix(int n) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};//ÓÒÏÂ×óÉÏ
        int[][] res = new int[n][n];
        int i = 0;
        int j = 0;
        int count = 1;
        int maxCount = n * n;
        int direction = 0;
        while (count <= maxCount){
            res[i][j] = count;
            int nextI = i + directions[direction][0];
            int nextJ = j + directions[direction][1];
            if(nextI == n || nextI < 0  || nextJ ==n || nextJ < 0 || res[nextI ][nextJ] != 0){
                direction = (direction + 1) % 4;
            }
            i = i + directions[direction][0];
            j = j + directions[direction][1];
            count++;
        }
        return res;
    }


}
