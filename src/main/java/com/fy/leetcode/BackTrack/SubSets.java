package com.fy.leetcode.BackTrack;

import java.security.interfaces.RSAKey;
import java.util.*;

/**
 * @Classname SubSets
 * @Description TODO
 * @Date 2022/1/19 10:43
 * @Created by fy
 */
public class SubSets {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> list = new LinkedList<>();
        dfs(0, nums,list);
        return ans;
    }

    public void dfs(int cur, int[] nums,Deque list) {
        if(cur == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.offerLast(nums[cur]);
        dfs(cur+1, nums, list);
        list.pollLast();
        dfs(cur+1, nums, list);
    }
}
