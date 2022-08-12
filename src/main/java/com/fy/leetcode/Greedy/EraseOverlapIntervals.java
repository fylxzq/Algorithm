package com.fy.leetcode.Greedy;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname EraseOverlapIntervals
 * @Description TODO
 * @Date 2022/6/30 22:21
 * @Created by fy
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals,(p1,p2) -> {
            if(p1[0] == p1[2]){
                return p1[1] <= p2[1] ? 1 : -1;
            }
            else{
                return p1[0] < p2[0] ? 1 : -1;
            }
        });
        int preMax = intervals[0][1];
        int res = 0;
        for(int i = 1; i < len; i++){
            if(intervals[i][0] > preMax){
                preMax = intervals[i][1];
            }
            else{
                res++;
            }
        }
        return res;
    }
}
