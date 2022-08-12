package com.fy.leetcode.Array;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ThreeSum
 * @Description TODO
 * @Date 2021/8/23 21:37
 * @Created by fy
 */
public class ThreeSum {
    @Test
    public void test(){
        List<int[]> list = new ArrayList<>();
    }
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 3){
            return res;
        }
        for(int first = 0; first < len - 2; first++){
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];
            int second = first + 1;
            int third = len - 1;
            while (second < third){
                if(nums[second] + nums[third] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                    second++;
                    third--;
                    while (second + 1 < third && nums[second] == nums[second + 1]){
                        second++;
                    }
                    while (second < third  - 1 && nums[third] == nums[third - 1]){
                        third--;
                    }
                }
                else if(nums[second] + nums[third] > target){
                    third--;
                }
                else{
                    second++;
                }
            }
        }
        return res;
    }
}
