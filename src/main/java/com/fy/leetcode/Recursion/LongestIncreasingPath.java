package com.fy.leetcode.Recursion;

import org.junit.Test;

/**
 * @Classname LongestIncreasingPath
 * @Description TODO
 * @Date 2022/3/19 18:26
 * @Created by fy
 */
public class LongestIncreasingPath {

    @Test
    public void test(){
        int[][] matrix = {{9,17,3,5,2,19},{19,13,7,9,7,12},{5,18,14,19,9,15},{11,17,5,0,10,18},{17,3,9,4,2,0},{5,10,5,13,4,10}};
        longestIncreasingPath(matrix);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] memory = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                int curres = dfs(matrix, i, j, memory);
                res = Math.max(curres, res);
            }
        }
        return res;
    }


    public int dfs(int[][] matrix,int row,int col,int[][] memory){
        if(memory[row][col] != 0){
            return memory[row][col];
        }
        else{
            int up = 0,down = 0,left = 0,right = 0;
            if(row - 1 >= 0 && matrix[row - 1][col] < matrix[row][col]){
                up = dfs(matrix, row - 1, col, memory);
            }
            if(row + 1 < matrix.length && matrix[row + 1][col] < matrix[row][col]){
                down = dfs(matrix, row + 1, col, memory);
            }
            if(col - 1 >= 0 && matrix[row][col - 1] < matrix[row][col]){
                left = dfs(matrix, row, col - 1, memory);
            }
            if(col + 1 < matrix[0].length && matrix[row][col + 1] < matrix[row][col]){
                right = dfs(matrix, row, col + 1, memory);
            }

            return Math.max(Math.max(up, down), Math.max(left, right)) + 1;

        }
    }
}
