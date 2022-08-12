package com.fy.leetcode.Recursion;

import java.util.*;

/**
 * @Classname SolveNQueens
 * @Description TODO
 * @Date 2022/5/24 21:11
 * @Created by fy
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        dfs(0, n, cols, diagonals1, diagonals2, queens, res);
        return res;
    }

    public void dfs(int row,int n, Set<Integer> cols,Set<Integer> diagonals1,Set<Integer> diagonals2,int[] queens,List<List<String>> res){
        if(row == n){
            generateStr(queens, res);
            return;
        }
        for(int i = 0; i < n; i++){
            if(cols.contains(i)){
                continue;
            }
            int diagonal1 = row - i;
            if(diagonals1.contains(diagonal1)){
                continue;
            }
            int diagonal2 = row + i;
            if(diagonals2.contains(diagonal2)){
                continue;
            }
            queens[row] = i;
            cols.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            dfs(row + 1,n, cols, diagonals1, diagonals2, queens, res);
            cols.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public void generateStr(int[] queens,List<List<String>> res){
        List<String> tmp = new ArrayList<>();
        for(int i = 0; i < queens.length; i++){
            char[] arr = new char[queens.length];
            Arrays.fill(arr, '.');
            arr[queens[i]] = 'Q';
            tmp.add(new String(arr));
        }
        res.add(tmp);
    }

}
