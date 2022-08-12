package com.fy.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ArrayChange
 * @Description TODO
 * @Date 2022/6/5 10:53
 * @Created by fy
 */
public class ArrayChange {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer>  map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int [] op : operations){
            int index = map.get(op[0]);
            nums[index] = op[1];
            map.remove(op[0]);
            map.put(op[1],index);
        }
        return nums;
    }
}
