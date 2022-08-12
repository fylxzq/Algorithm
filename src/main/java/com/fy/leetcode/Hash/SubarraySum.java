package com.fy.leetcode.Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname SubarraySum
 * @Description TODO
 * @Date 2022/3/9 20:00
 * @Created by fy
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int num : nums){
            sum += num;
            int target = num - k;
            res += map.getOrDefault(target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }


}
