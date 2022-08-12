package com.fy.leetcode.Recursion;

import org.junit.Test;

/**
 * @Classname HasValidPath
 * @Description TODO
 * @Date 2022/5/9 16:00
 * @Created by fy
 */
public class HasValidPath {
    @Test
     public void test(){
        char[][] chars = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        hasValidPath(chars);
    }

    int row,col;
    boolean[][][] vis;
    char[][] grid;
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        int row = grid.length;
        int col = grid[0].length;
        this.row = row;
        this.col = col;
        int maxlen = row + col ;
        if(maxlen % 2 == 0 || grid[0][0] == ')' || grid[row - 1][col - 1] == '('){
            return false;
        }
        this.vis = new boolean[row][col][(maxlen + 1) / 2];
        return dfs(0, 0, 0);
    }

    public boolean dfs(int i,int j,int c){
        if(c > row - i + col - j - 1){
            return false;//// 剪枝：即使后面都是 ')' 也不能将 c 减为 0
        }
        if(i == row - 1 && j == col - 1){
            return c == 1;// 终点一定是 ')'
        }
        if(vis[i][j][c]){
            return false;
        }
        vis[i][j][c] = true;
        c += grid[i][j] == '(' ? 1 :  -1;
        return c >= 0 && (i < row && dfs(i + 1, j, c) || j < col && dfs(i, j + 1, c));
    }
}
