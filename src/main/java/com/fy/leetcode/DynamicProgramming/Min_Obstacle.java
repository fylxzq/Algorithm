package com.fy.leetcode.DynamicProgramming;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.nio.charset.IllegalCharsetNameException;
import java.util.LinkedList;

/**
 * @Classname Min_Obstacle
 * @Description TODO
 * @Date 2021/8/2 8:59
 * @Created by fy
 */

/*
* 题目描述：一个 n*m的迷宫矩阵maze，坐标从左上角到右下角一次为(1,1),....(n,m)
* 现在飞飞站在坐标(1,1)处，现在他想要到达坐标(n,m)处，每次飞飞只能从上下左右移动一个单位，
*每个坐标(i,j)只可能是道路或者障碍物，飞飞只能在道路行走而无法通过障碍物，现在飞飞可以选择一些障碍物
* 将其变为道路。他想知道至少选择多少个障碍物才能将他们变为道路才能从(1,1)到达(n,m)
* 示例(#为障碍，.为道路，起点和终点只能是.)
* . # #
* # # .
* . . .
*
* */
public class Min_Obstacle {


    public int search_min_path(int n, int m, char[][] maze_maxtrix){
        int[][] dp = new int[n][m];
        for(int i = 0;i < n; ++i){
            for(int j = 0;j < m; ++j){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;//初始化dp，除了(0,0)位置，均设置为最大值
        /*本题的解题思路主要是bfs加动态规划，所以需要构造一个队列que
        * */
        LinkedList<int[]> que = new LinkedList<int[]>();
        que.addLast(new int[]{0,0});

        while ( !que.isEmpty() ){
            int[] tmp = que.removeFirst();//出队队首元素
            int x = tmp[0];
            int y = tmp[1];
            if (infect(x, y-1, dp[x][y], dp,maze_maxtrix)){
                que.addLast(new int[]{x,y-1});
            }
            if (infect(x, y+1, dp[x][y], dp,maze_maxtrix)){
                que.addLast(new int[]{x,y+1});
            }
            if (infect(x-1, y, dp[x][y], dp,maze_maxtrix)){
                que.addLast(new int[]{x-1,y});
            }
            if (infect(x+1, y, dp[x][y], dp,maze_maxtrix)){
                que.addLast(new int[]{x+1,y});
            }
        }
        return dp[n-1][m-1];

    }

    public boolean infect(int i, int j,int point, int[][] dp,char[][] maze_matrix){
        int row = maze_matrix.length;
        int col = maze_matrix[0].length;
        if(i<0 || i >= row || j < 0 || j >= col){
            return false;
        }
        if(maze_matrix[i][j] == '.' & point < dp[i][j]){//这里的point<dp[i][j]是特别重要的一步
            dp[i][j] = point;
            return true;
        }
        if(maze_matrix[i][j] == '#' & point + 1 < dp[i][j]){
            dp[i][j] = point + 1;
            return true;
        }
        return false;
    }
}
