package com.fy.leetcode.DynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Classname MinimumObstacles
 * @Description TODO
 * @Date 2022/5/29 13:51
 * @Created by fy
 */
public class MinimumObstacles {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] steps = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] dp = new int[m][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((arr1,arr2) ->{
            return dp[arr1[0]][arr1[1]] - dp[arr2[0]][arr2[1]];
        });
        boolean[][] vis = new boolean[m][n];
        priorityQueue.add(new int[]{0,0});
        vis[0][0] = true;
        int count = 0;
        while (!priorityQueue.isEmpty()){
            int[] point = priorityQueue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < 4; i++){
                int nextX = steps[i][0] + x;
                int nextY = steps[i][1] + y;
                if(nextX < 0 || nextY < 0 || nextX == m || nextY == n || vis[nextX][nextY]){
                    continue;
                }
                dp[nextX][nextY] = dp[x][y] + grid[nextX][nextY];
                vis[nextX][nextY] = true;
                priorityQueue.add(new int[]{nextX,nextY});
            }
        }
        return dp[m - 1][n - 1];
    }
}
