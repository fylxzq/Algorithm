package com.fy.leetcode.Strs;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname SmallestTrimmedNumbers
 * @Description TODO
 * @Date 2022/7/17 11:09
 * @Created by fy
 */
public class SmallestTrimmedNumbers {
    @Test
    public void test(){
        String[] nums = {"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"};
        int[][] queries = new int[][] {{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},{13,1},{13,1},{6,1},{5,10}};
        smallestTrimmedNumbers(nums, queries);
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        String[][] tmpArr = new String[nums.length][2];
        int preTrimLen = 0;
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(queries[i][1] != preTrimLen){
                for(int j = 0; j < nums.length; j++){
                    tmpArr[j][0] = nums[j].substring(nums[j].length() - queries[i][1]);
                    tmpArr[j][1] = String.valueOf(j);
                }
                Arrays.sort(tmpArr,(arr1,arr2) -> {
                    if(arr1[0].equals(arr2[0])){
                        return arr1[0].compareTo(arr2[0]);
                    }
                    else{
                        return Integer.valueOf(arr1[1]).compareTo(Integer.valueOf(arr2[1]));
                    }
                });

            }
            res[i] = Integer.parseInt(tmpArr[queries[i][0] - 1][1]);
        }
        return res;
    }
}
