package com.fy.leetcode.Array;

import sun.plugin.WJcovUtil;

import java.util.*;

/**
 * @Classname InsertIntervals
 * @Description TODO
 * @Date 2022/5/15 21:59
 * @Created by fy
 */
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        TreeMap<Integer,int[]> treeMap = new TreeMap<>();
        for(int[] interval : intervals){
            treeMap.put(interval[0],interval);
        }
        int left = newInterval[0];
        int right = newInterval[1];
        Map.Entry<Integer, int[]> floorEntry = treeMap.floorEntry(right);
        while (floorEntry != null && floorEntry.getValue()[1] >= left){
            left = Math.min(left, floorEntry.getValue()[0]);
            right = Math.max(right, floorEntry.getValue()[1]);
            treeMap.remove(floorEntry.getKey());
            floorEntry = treeMap.floorEntry(right);
        }
        treeMap.put(left, new int[]{left,right});
        Set<Map.Entry<Integer, int[]>> entriesset = treeMap.entrySet();
        int[][] res = new int[treeMap.size()][2];
        int count = 0;
        for(Map.Entry<Integer, int[]> entry : entriesset){
            res[count] = entry.getValue();
        }
        return res;
    }
}
