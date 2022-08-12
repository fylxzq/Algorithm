package com.fy.leetcode.Array;

import java.util.*;

/**
 * @Classname CountIntervals
 * @Description TODO
 * @Date 2022/5/15 11:49
 * @Created by fy
 */
public class CountIntervals {
    TreeMap<Integer,int[]> treeMap;
    int sum = 0;
    public CountIntervals() {
        treeMap = new TreeMap<>();
    }

    public void add(int left, int right) {
        Map.Entry<Integer, int[]> floorEntry = treeMap.floorEntry(right);
        while (floorEntry != null && floorEntry.getValue()[1] >= left){
            sum -= (floorEntry.getValue()[1] - floorEntry.getValue()[0]);
            left = Math.min(left, floorEntry.getValue()[0]);
            right = Math.max(right, floorEntry.getValue()[1]);
            treeMap.remove(floorEntry.getKey());
            floorEntry = treeMap.floorEntry(right);
        }
        treeMap.put(left, new  int[]{left,right});
        sum += (right - left + 1);
    }

    public int count() {
        return sum;
    }
}
