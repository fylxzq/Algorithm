package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname solveSudoku
 * @Description TODO
 * @Date 2022/5/15 20:39
 * @Created by fy
 */
public class SolveSudoku {
    @Test
    public void test(){
        char[][] boards = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku(boards);
        for(char[] e : boards){
            System.out.println(Arrays.toString(e));
        }
    }
    boolean valid = false;
    public void solveSudoku(char[][] board) {
        boolean[][] lineFlags = new boolean[9][9];
        boolean[][] columnFlags = new boolean[9][9];
        boolean[][][] blockFlags = new boolean[3][3][9];
        List<int[]> emptyCells = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    emptyCells.add(new int[]{i,j});
                }
                else {
                    int usedNum = board[i][j] - '0' - 1;
                    lineFlags[i][usedNum] = columnFlags[j][usedNum] = blockFlags[i / 3][j / 3][usedNum] = true;
                }
            }
        }
        dfs(board, 0, lineFlags, columnFlags, blockFlags, emptyCells);
    }

    public void dfs(char[][] board, int pos,boolean[][] lineFlags,boolean[][] columnFlags,boolean[][][] blockFlags,List<int[]> emptyCells){
        if(emptyCells.size() == pos){
            valid = true;
            return;
        }
        int[] point = emptyCells.get(pos);
        int row = point[0];
        int col = point[1];
        for(int i = 0; i < 9 && !valid; i++){
            if( !lineFlags[row][i] && !columnFlags[col][i] && !blockFlags[row / 3][col / 3][i]){
                lineFlags[row][i] = columnFlags[col][i] = blockFlags[row / 3][col / 3][i] = true;
                board[row][col] = (char) (i + '0' + 1);
                dfs(board, pos + 1, lineFlags, columnFlags, blockFlags, emptyCells);
                lineFlags[row][i] = columnFlags[col][i] = blockFlags[row / 3][col / 3][i] = false;
            }
        }
    }
}
