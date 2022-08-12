package com.fy.leetcode.BackTrack;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SolveSudoku2
 * @Description TODO
 * @Date 2022/7/20 19:15
 * @Created by fy
 */
public class SolveSudoku2 {
    int[] rowFlags = new int[9];
    int[] colFlags = new int[9];
    int[][] blockFlags = new int[3][3];
    boolean valid = true;
    public void solveSudoku(char[][] board) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    list.add(new int[]{i,j});
                }else{
                    flip(i, j,(int)(board[i][j] - '1'));
                }
            }
        }
        dfs(board, list, 0);

    }

    public void dfs(char[][] board,List<int[]> list,int index){
        if(index == list.size()){
            valid = false;
            return;
        }
        int[] point = list.get(index);
        int x = point[0];
        int y = point[1];
        int mask = ~(rowFlags[x] | colFlags[y] | blockFlags[x / 3][y / 3]) & 1111111111;
        for(;mask != 0  && valid; mask &= (mask - 1)){
            int digmask = mask & (-mask);
            int digit = Integer.bitCount(digmask - 1);
            flip(x, y, digit);
            board[x][y] = (char) (digit + '1');
            dfs(board, list, index + 1);
            flip(x, y, digit);
        }
    }

    public void flip(int i, int j,int bits){
        rowFlags[i] |= 1 << bits;
        colFlags[j] |= 1 << bits;
        blockFlags[i / 3][j / 3] |= 1 << bits;
    }
}
