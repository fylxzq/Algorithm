package com.fy.leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname NumberOfPairs
 * @Description TODO
 * @Date 2022/7/17 10:34
 * @Created by fy
 */
public class NumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int pairNum = 0;
        int restNum = 0;
        for(Map.Entry<Integer,Integer> entry : entries){
            int curNumPairNum = entry.getValue() / 2;
            int isRest = entry.getValue() % 2;
            pairNum += curNumPairNum;
            restNum += isRest == 1 ? 1 : 0;
        }
        return new int[]{pairNum,restNum};
    }
}
