package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname CountExcellentPairs
 * @Description TODO
 * @Date 2022/7/24 11:23
 * @Created by fy
 */
public class CountExcellentPairs {
    @Test
    public void test(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.add(1));
    }

    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int[] bitsArr = new int[33];
        for(int num : nums){
            if( !set.add(num) ){
                continue;
            }
            ++bitsArr[Integer.bitCount(num)];
        }
        long res = 0;
        for(int i = 0; i <= 32; i++){
            for(int j = Math.max(i, k - i); j <= 32; j++){
                res += (long) bitsArr[i] * bitsArr[j];
            }
        }
        return res;
    }
}
