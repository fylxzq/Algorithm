package com.fy.leetcode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname CountDistinct
 * @Description TODO
 * @Date 2022/5/1 19:21
 * @Created by fy
 */
public class CountDistinct {
    public int countDistinct(int[] nums, int k, int p) {
        char c = (char) ((k % 26) + 'A');
        int res = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int j = i; j >= 0; j--){
                sb.append(nums[j]).append("_");//加_的原因是可能存在1,1,11
                if(nums[j] % p == 0){
                    count++;
                }
                if(count <= k && !set.contains(nums[j] + "_")){
                    set.add(sb.toString());
                    res++;
                }
            }
        }
        return res;
    }
}
