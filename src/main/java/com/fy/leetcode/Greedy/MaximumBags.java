package com.fy.leetcode.Greedy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Classname MaximumBags
 * @Description TODO
 * @Date 2022/5/22 10:38
 * @Created by fy
 */
public class MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        TreeMap<Integer,Integer> map = new TreeMap<>();//记录还可以装K个石头的背包个数
        for(int i = 0; i < capacity.length; i++){
            int extraSpace = capacity[i] - rocks[i];
            map.put(extraSpace,map.getOrDefault(extraSpace, 0) + 1);
        }
        int res = 0;
        while (additionalRocks > 0){
            if(map.size() == 0){
                break;
            }
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            if(entry.getKey() == 0){
                res += entry.getValue();
            }
            else{
                int maxNum = additionalRocks / entry.getKey();
                if(maxNum == 0){
                    break;
                }
                int canPutMaxNum = Math.min(entry.getValue(), maxNum);
                res += canPutMaxNum;
                additionalRocks -= (entry.getKey() * canPutMaxNum);
            }
        }
        return res;
    }
}
