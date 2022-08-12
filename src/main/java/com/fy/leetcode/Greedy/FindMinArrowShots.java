package com.fy.leetcode.Greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname FindMinArrowShots
 * @Description TODO
 * @Date 2022/6/30 21:53
 * @Created by fy
 */
public class FindMinArrowShots {
    @Test
    public void test(){
        int[][] nums = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Arrays.sort(nums,(p1,p2) -> p1[0] < p2[0] ? -1 : 1);
        for(int[] p : nums){
            System.out.println(Arrays.toString(p));;
        }
    }

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        Arrays.sort(points,(p1,p2) -> p1[0] - p2[0]);
        int preArrow = points[0][1];
        int res = 1;
        for(int i = 1; i < len; i++){
            if(preArrow < points[i][0]){
                preArrow = points[i][1];
                res++;
            }
        }
        return res;
    }
}
