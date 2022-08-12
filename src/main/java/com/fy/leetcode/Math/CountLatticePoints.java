package com.fy.leetcode.Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname CountLatticePoints
 * @Description TODO
 * @Date 2022/7/27 19:04
 * @Created by fy
 */
public class CountLatticePoints {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        Arrays.sort(circles,(arr1,arr2) -> {
            return arr2[2] - arr1[2];
        });
        for(int[] circle : circles){
            int xMax = circle[0] + circle[2];
            int xMin = circle[0] - circle[2];
            int yMax = circle[1] + circle[2];
            int yMin = circle[1] - circle[2];
            for(int i = xMin; i <= xMax; i++){
                for(int j = yMin; j <= yMax; j++){
                    if(!set.contains(i + "_" + j) && (i - circle[0]) * (i - circle[0]) + (j - circle[1]) * (j - circle[1]) <= circle[2] * circle[2]){
                        set.add(i + " _" + j);
                    }
                }
            }
        }
        return set.size();
    }
}
