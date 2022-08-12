package com.fy.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname MaximalRectangle
 * @Description TODO
 * @Date 2022/6/1 8:57
 * @Created by fy
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] heights = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                heights[i][j] = (matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < row; i++){
            int[] newHeights = new int[col + 2];
            System.arraycopy(heights[i],0,newHeights, 1, col);
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            for(int j = 1; j < col + 2; j++){
                while (newHeights[j] > newHeights[stack.peek()]){
                    int height = newHeights[stack.pop()];
                    int width = j - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }
            }
        }
        return res;
    }
}
