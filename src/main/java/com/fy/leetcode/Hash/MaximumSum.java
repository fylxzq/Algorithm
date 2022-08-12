package com.fy.leetcode.Hash;

import java.util.*;

/**
 * @Classname MaximumSum
 * @Description TODO
 * @Date 2022/7/17 10:47
 * @Created by fy
 */
public class MaximumSum {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num : nums){
            int key = getBitsSum(num);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(num);
            map.put(key, list);
        }
        int res = -1;
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for(Map.Entry<Integer,List<Integer>> entry : entries){
            List<Integer> valueList = entry.getValue();
            if(valueList.size() > 1){
                valueList.sort((num1, num2) -> {
                    return num2 - num1;
                });
                res = Math.max(valueList.get(0) + valueList.get(1),res);
            }
        }
        return res;
    }

    public int getBitsSum(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
