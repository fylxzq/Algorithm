package com.fy.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LengthOfLIS
 * @Description TODO
 * @Date 2022/7/28 19:31
 * @Created by fy
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            int high = list.size() - 1;
            int low = 0;
            while (low < high){
                int mid = (high - low) / 2 + low;
                if(nums[mid] > num){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            if(high + 1== list.size()){
                list.add(num);
            }
        }
        return list.size();
    }
}
