package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname EqualPairs
 * @Description TODO
 * @Date 2022/7/24 11:02
 * @Created by fy
 */
public class EqualPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String,Integer> rowSequences = new HashMap<>();
        Map<String,Integer> colSequences = new HashMap<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb1.append(grid[i][j]);
                sb1.append("_");
                sb2.append(grid[j][i]);
                sb2.append("_");
            }
            String rowSequence = sb1.toString();
            String colSequence = sb2.toString();
            rowSequences.put(rowSequence, rowSequences.getOrDefault(rowSequence,0) + 1);
            colSequences.put(colSequence, colSequences.getOrDefault(colSequence,0) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = rowSequences.entrySet();
        int sum = 0;
        for(Map.Entry<String, Integer> entry : entries){
            if(colSequences.containsKey(entry.getKey())){
                sum += (entry.getValue() * colSequences.get(entry.getKey()));
            }
        }
        return sum;

    }
}
