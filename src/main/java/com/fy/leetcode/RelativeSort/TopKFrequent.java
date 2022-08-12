package com.fy.leetcode.RelativeSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TopKFrequent
 * @Description TODO
 * @Date 2022/3/25 9:58
 * @Created by fy
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[][] freq = new int[size][2];
        int count = 0;
       for (Map.Entry<Integer,Integer> entry : map.entrySet()){
           freq[count] = new int[]{entry.getKey(),entry.getValue()};
       }
        Arrays.sort(freq,(o1,o2) -> o1[1] - o2[1]);
       count = 0;
       int[] res = new int[k];
       for(int i = 0; i < k; ++i){
           res[i] = freq[i][0];
       }
       return res;
    }
}
