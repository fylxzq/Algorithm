package com.fy.leetcode.Other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname BestRouteOfChangeingMap
 * @Description TODO
 * @Date 2021/8/28 9:42
 * @Created by fy
 */
public class BestRouteOfChangeingMap {


    public int getMinValueOfRoute(int[][] matrix){
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; ++i){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        class Node{
            int x;
            int y;
            int hop;

            public Node(int x, int y, int hop) {
                this.x = x;
                this.y = y;
                this.hop = hop;
            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0, 0, 0));
        while ( !queue.isEmpty() ){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int hop = node.hop;
            if(dp[x][y] <= hop || matrix[x][y] < hop){
                continue;
            }//这是关键的一部分
            if( x == n -1 && y == m -1 ){
                return hop;
            }
            for(int i = 0; i < dx.length; ++i){
                int nextX = dx[i] + x;
                int nextY = dy[i] + y;
                if( !inGrid(x, y, n, m)){
                    continue;
                }
                queue.add(new Node(nextX, nextY, hop + 1));
            }
        }
        return -1;
    }

    public boolean inGrid(int x , int y ,int n ,int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
