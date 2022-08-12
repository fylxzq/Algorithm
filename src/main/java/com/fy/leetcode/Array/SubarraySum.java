package com.fy.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname SubarraySum
 * @Description TODO
 * @Date 2022/4/19 10:59
 * @Created by fy
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int presum = 0;
        map.put(0, 0);
        int res = 0;
        for(int i = 0; i < len; i++){
            presum += nums[i];
            int target = presum - k;
            if(map.containsKey(target)){
                res += map.get(target);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return res;
    }
}
