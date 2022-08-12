package com.fy.leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Permute
 * @Description TODO
 * @Date 2021/12/25 14:00
 * @Created by fy
 */
public class Permute {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<Integer>();
        dfs(nums, used, list, len);
        return rst;
    }

    public void  dfs(int[] nums, boolean[] used, List<Integer> list,int len){
        for(int i = 0 ;  i< len; ++i){
            if(used[i] == true){
                continue;
            }
            else{
                list.add(nums[i]);
                used[i] = true;
                int size = list.size();
                if(size == len){
                    List<Integer> one_array = new ArrayList();
                    for(Integer num:list){
                        one_array.add(num);
                    }
                    rst.add(one_array);
                }
                else{
                    dfs(nums, used, list, len);
                }
                used[i] = false;
                list.remove(size-1);
            }
        }
    }
}
