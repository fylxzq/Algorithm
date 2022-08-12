package com.fy.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname FourSum
 * @Description TODO
 * @Date 2022/5/25 13:25
 * @Created by fy
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if(nums[i] + nums[len - 1] + nums[len -2 ] + nums[len - 3] < target){
                continue;
            }
            for(int j = i + 1; j < len - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if(nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target){
                    continue;
                }
                int third = j + 1;
                int four = len - 1;
                int extraTarget = target - nums[i] - nums[j];
                while (third < four){
                    if(nums[third] + nums[four] > extraTarget){
                        four--;
                    }
                    else if(nums[four] + nums[third] < extraTarget){
                        third++;
                    }
                    else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[third],nums[four]));
                        while (third < four && nums[third] == nums[third + 1]){
                            third++;
                        }
                        third++;
                        while (third < four && nums[four] == nums[four - 1]){
                            four--;
                        }
                        four--;
                    }
                }
            }
        }
        return res;
    }
}
