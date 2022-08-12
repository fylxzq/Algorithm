package com.fy.leetcode.Strs;

import java.util.Arrays;

/**
 * @Classname minNumber
 * @Description TODO
 * @Date 2022/3/25 12:58
 * @Created by fy
 */
public class minNumber {
    public String minNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        for(int i = 0; i < nums_str.length; i++){
            nums_str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums_str, (st1,str2) -> {
            return (st1 + str2).compareTo(str2 + st1);
        });
        StringBuilder sb = new StringBuilder();
        for(String numstr : nums_str){
            sb.append(numstr);
        }
        return sb.toString();
    }
}
