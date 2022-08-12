package com.fy.leetcode.Hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Classname TwoSum
 * @Description TODO
 * @Date 2021/7/18 16:59
 * @Created by fy
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        int[] rst = new int[2];
        HashMap<Integer,Integer> table = new HashMap<Integer, Integer>();
        int length = nums.length;
        for(int i = 0;i < length; ++i){
            int tmpvalue = nums[i];
            if(table.containsKey(tmpvalue)){
                rst[0] = table.get(tmpvalue);
                rst[1] = i;
            }
            else{
                table.put(target-tmpvalue, i);
            }
        }
        return rst;
    }
}
