package com.fy.leetcode.BackTrack;

import com.sun.rowset.internal.Row;

import java.io.Serializable;
import java.util.*;

/**
 * @Classname SolvNeQueens
 * @Description TODO
 * @Date 2022/7/20 19:50
 * @Created by fy
 */
public class SolvNeQueens {
    Set<Integer> colFlags = new HashSet<>();
    Set<Integer> leftDowFlags = new HashSet<>();
    Set<Integer> rightUpFlags = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] rows = new int[n];
        dfs(0, rows);
        return res;
    }

    public void dfs(int index, int[] rows){
        if(index == rows.length){
            generate(rows);
            return;
        }
        for(int i = 0; i < rows.length; i++){
            if( !colFlags.contains(i) && !leftDowFlags.contains(i - index) && !rightUpFlags.contains(i +index)){
                colFlags.add(i);
                leftDowFlags.add(i - index);
                rightUpFlags.add(i + index);
                rows[index] = i;
                dfs(index + 1, rows);
                colFlags.remove(i);
                leftDowFlags.remove(i - index);
                rightUpFlags.remove(i + index);
            }
        }
    }

    private void generate(int[] rows) {
        List<String> list = new ArrayList<>();
        char[] arr = new char[rows.length];
        for (int row : rows) {
            Arrays.fill(arr, '.');
            arr[row] = 'Q';
            list.add(new String(arr));
        }
        res.add(list);
    }
}
