package com.fy.leetcode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ReconstructQueue
 * @Description TODO
 * @Date 2022/6/30 20:31
 * @Created by fy
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(e1,e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }
            else{
                return e2[0] - e1[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] onePep : people){
            list.add(onePep[1],onePep);
        }
        return list.toArray(new int[people.length][]);
    }
}
