package com.fy.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SolveSudoku
 * @Description TODO
 * @Date 2022/7/19 19:59
 * @Created by fy
 */
public class SolveSudoku {
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        List<int[]> list = new ArrayList<>();
        boolean[][] rowFlags = new boolean[9][9];
        boolean[][] colFlags = new boolean[9][9];
        boolean[][][] blockFlags = new boolean[3][3][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char e = board[i][j];
                if(e == '.'){
                    list.add(new int[]{i,j});
                }
                else{
                    rowFlags[i][e - '1'] = true;
                    colFlags[j][e - '1'] = true;
                    blockFlags[i / 3][j / 3][e - '1'] = true;
                }
            }
        }
        dfs(board, 0, list, rowFlags, colFlags, blockFlags);
    }

    public void dfs(char[][] board,int index,List<int[]> list,boolean[][] rowFlags,boolean[][] colFlags,boolean[][][] blockFlags){
        if(index == list.size()){
            valid = true;
            return;
        }
        int[] point = list.get(index);
        for(int i = 0; i < 9 && !valid; i++){
            int x = point[0];
            int y = point[1];
            boolean rowFlag = rowFlags[x][i];
            boolean colFlag = colFlags[y][i];
            boolean blockFlag = blockFlags[x / 3][y / 3][i];
            if(!rowFlag && !colFlag && !blockFlag){
                board[x][y] = (char) (i + '1');
                rowFlags[x][i] = true;
                colFlags[y][i] = true;
                blockFlags[x / 3][y / 3][i] = true;
                dfs(board, index + 1, list, rowFlags, colFlags, blockFlags);
                rowFlags[x][i] = false;
                colFlags[y][i] = false;
                blockFlags[x / 3][y / 3][i] = false;
            }
        }
    }

}
