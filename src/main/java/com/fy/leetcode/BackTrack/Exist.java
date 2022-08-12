package com.fy.leetcode.BackTrack;

/**
 * @Classname Exist
 * @Description TODO
 * @Date 2022/6/10 14:28
 * @Created by fy
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean tmp = false;
        boolean[][] used = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                tmp = tmp || dfs(board,i,j,word,used,m,n,count);
            }
        }
        return tmp;
    }
    public boolean dfs(char[][] board, int i, int j, String word, boolean[][] used, int m, int n,int count){
        if(count == word.length()){
            return true;
        }
        if(board[i][j] != word.charAt(count)){
            return false;
        }
        used[i][j] = true;
        boolean up = false, down = false, left = false, right = false;
        if(i - 1 >= 0 && !used[i - 1][j]){
            up = dfs(board, i - 1, j , word, used, m, n, count + 1);
        }
        if(i + 1 < m && !used[i + 1][j]){
            down = dfs(board, i + 1, j , word, used, m, n, count + 1);
        }
        if(j - 1 >= 0 && !used[i][j - 1]){
            left = dfs(board, i, j - 1, word, used, m, n, count + 1);
        }
        if(j + 1 < n && !used[i][j + 1]){
            right = dfs(board, i, j + 1, word, used, m, n, count + 1);
        }
        used[i][j] = false;
        return left || right || down || up;
    }

}
