package com.fy.leetcode.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname FindDuplicates
 * @Description TODO
 * @Date 2022/3/29 15:08
 * @Created by fy
 */
public class FindDuplicates {
    @Test
    public void test(){
        int[] nums = {1,1,2};
        findDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int curNum = Math.abs(nums[i]);
            if (nums[curNum-1] < 0) ans.add(curNum);
            nums[curNum-1] *= (-1);
        }
        return ans;
    }
}
