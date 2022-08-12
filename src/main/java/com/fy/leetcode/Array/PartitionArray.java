package com.fy.leetcode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname PartitionArray
 * @Description TODO
 * @Date 2022/6/5 11:04
 * @Created by fy
 */
public class PartitionArray {
    public void test(){
        int[] nums = {16,8,17,0,3,17,8,20};
        int n = 10;
    }
    public int partitionArray(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        for(int num : nums){
            minVal = Math.min(minVal, num);
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            int group = (num - minVal) / (k + 1);
            set.add(group);
        }
        return set.size();
    }
}
