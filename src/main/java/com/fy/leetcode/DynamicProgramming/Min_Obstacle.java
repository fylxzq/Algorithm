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
* ��Ŀ������һ�� n*m���Թ�����maze����������Ͻǵ����½�һ��Ϊ(1,1),....(n,m)
* ���ڷɷ�վ������(1,1)������������Ҫ��������(n,m)����ÿ�ηɷ�ֻ�ܴ����������ƶ�һ����λ��
*ÿ������(i,j)ֻ�����ǵ�·�����ϰ���ɷ�ֻ���ڵ�·���߶��޷�ͨ���ϰ�����ڷɷɿ���ѡ��һЩ�ϰ���
* �����Ϊ��·������֪������ѡ����ٸ��ϰ�����ܽ����Ǳ�Ϊ��·���ܴ�(1,1)����(n,m)
* ʾ��(#Ϊ�ϰ���.Ϊ��·�������յ�ֻ����.)
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
        dp[0][0] = 0;//��ʼ��dp������(0,0)λ�ã�������Ϊ���ֵ
        /*����Ľ���˼·��Ҫ��bfs�Ӷ�̬�滮��������Ҫ����һ������que
        * */
        LinkedList<int[]> que = new LinkedList<int[]>();
        que.addLast(new int[]{0,0});

        while ( !que.isEmpty() ){
            int[] tmp = que.removeFirst();//���Ӷ���Ԫ��
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
        if(maze_matrix[i][j] == '.' & point < dp[i][j]){//�����point<dp[i][j]���ر���Ҫ��һ��
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
