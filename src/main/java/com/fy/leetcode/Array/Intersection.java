package com.fy.leetcode.Array;

import java.util.*;

/**
 * @Classname Intersection
 * @Description TODO
 * @Date 2022/4/24 10:31
 * @Created by fy
 */
public class Intersection {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        for(int[] numsArr : nums){
            for(int num : numsArr){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries){
            if(entry.getValue() == size){
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }
}
