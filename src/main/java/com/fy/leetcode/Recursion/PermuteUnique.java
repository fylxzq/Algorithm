package com.fy.leetcode.Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname PermuteUnique
 * @Description TODO
 * @Date 2022/3/14 8:43
 * @Created by fy
 */
public class PermuteUnique {
    @Test
    public void test() {
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> oneres = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, oneres, res,used);
        return res;
    }

    public void dfs(int[] nums,List<Integer> oneres,List<List<Integer>> res,boolean[] used){
        if(oneres.size() == nums.length){
            res.add(new ArrayList<>(oneres));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i]){
                continue;
            }
            oneres.add(nums[i]);
            used[i] = true;
            dfs(nums, oneres, res, used);
            oneres.remove(oneres.size() - 1);
            used[i] = false;
        }
    }
}
